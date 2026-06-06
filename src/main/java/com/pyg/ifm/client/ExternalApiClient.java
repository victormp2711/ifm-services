package com.pyg.ifm.client;

import com.pyg.ifm.exception.BusinessApiException;
import com.pyg.ifm.exception.UpstreamApiException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class ExternalApiClient {

    private final WebClient webClient;
    private final ReactiveCircuitBreakerFactory<?, ?> circuitBreakerFactory;

    public <T> Mono<T> post(String uri, Object body, Class<T> responseType, String circuitBreakerName) {
        ReactiveCircuitBreaker circuitBreaker = circuitBreakerFactory.create(circuitBreakerName);
        Mono<T> operation = webClient.post()
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType)
                .onErrorMap(throwable -> mapThrowable(throwable, circuitBreakerName));

        return circuitBreaker.run(operation, throwable -> handleFallback(throwable, circuitBreakerName));
    }

    public <T> Flux<T> postFlux(String uri, Object body, Class<T> responseType, String circuitBreakerName) {
        ReactiveCircuitBreaker circuitBreaker = circuitBreakerFactory.create(circuitBreakerName);
        Mono<java.util.List<T>> operation = webClient.post()
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .bodyToFlux(responseType)
                .collectList()
                .onErrorMap(throwable -> mapThrowable(throwable, circuitBreakerName));

        return circuitBreaker.run(operation, throwable -> handleFallback(throwable, circuitBreakerName))
                .flatMapMany(Flux::fromIterable);
    }

    private <T> Mono<T> handleFallback(Throwable throwable, String circuitBreakerName) {
        if (throwable instanceof CallNotPermittedException) {
            log.warn("Circuit breaker '{}' abierto; rechazando llamada", circuitBreakerName);
            return Mono.error(UpstreamApiException.circuitOpen(circuitBreakerName));
        }
        if (throwable instanceof BusinessApiException || throwable instanceof UpstreamApiException) {
            return Mono.error(throwable);
        }
        return Mono.error(mapThrowable(throwable, circuitBreakerName));
    }

    private Throwable mapThrowable(Throwable throwable, String circuitBreakerName) {
        if (throwable instanceof BusinessApiException || throwable instanceof UpstreamApiException) {
            return throwable;
        }
        if (throwable instanceof CallNotPermittedException) {
            return UpstreamApiException.circuitOpen(circuitBreakerName);
        }
        if (throwable instanceof WebClientResponseException responseException) {
            return mapWebClientException(responseException);
        }
        log.warn("Error de comunicación con API externa [{}]: {}", circuitBreakerName, throwable.getMessage());
        return UpstreamApiException.fromUpstream(
                HttpStatus.BAD_GATEWAY,
                "No fue posible comunicarse con el servicio externo",
                null,
                throwable
        );
    }

    private Throwable mapWebClientException(WebClientResponseException exception) {
        HttpStatus status = HttpStatus.resolve(exception.getStatusCode().value());
        if (status == null) {
            status = HttpStatus.BAD_GATEWAY;
        }
        String body = exception.getResponseBodyAsString();
        String message = "Error en servicio externo: " + status.value() + " " + status.getReasonPhrase();

        if (exception.getStatusCode().is4xxClientError()) {
            log.debug("Error de negocio upstream {} - {}", status.value(), body);
            return new BusinessApiException(status, message, body, exception);
        }

        log.warn("Error upstream {} - {}", status.value(), body);
        return UpstreamApiException.fromUpstream(status, message, body, exception);
    }
}
