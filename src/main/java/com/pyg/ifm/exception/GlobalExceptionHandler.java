package com.pyg.ifm.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessApiException.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleBusiness(
            BusinessApiException ex,
            ServerWebExchange exchange
    ) {
        return Mono.just(buildResponse(ex.getStatus(), ex.getErrorType(), ex.getMessage(), ex.getUpstreamBody(), exchange));
    }

    @ExceptionHandler(UpstreamApiException.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleUpstream(
            UpstreamApiException ex,
            ServerWebExchange exchange
    ) {
        if (ex.getErrorType() == ApiErrorType.CIRCUIT_OPEN) {
            log.warn("Respuesta por circuit breaker abierto en {}", exchange.getRequest().getPath());
        } else {
            log.error("Fallo de servicio externo en {}: {}", exchange.getRequest().getPath(), ex.getMessage());
        }
        return Mono.just(buildResponse(ex.getStatus(), ex.getErrorType(), ex.getMessage(), ex.getUpstreamBody(), exchange));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleValidation(
            WebExchangeBindException ex,
            ServerWebExchange exchange
    ) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((a, b) -> a + "; " + b)
                .orElse("Datos de entrada inválidos");
        return Mono.just(buildResponse(
                HttpStatus.BAD_REQUEST,
                ApiErrorType.BUSINESS,
                message,
                null,
                exchange
        ));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiErrorResponse>> handleGeneric(Exception ex, ServerWebExchange exchange) {
        log.error("Error no controlado en {}", exchange.getRequest().getPath(), ex);
        return Mono.just(buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ApiErrorType.UPSTREAM,
                "Error interno del servicio",
                null,
                exchange
        ));
    }

    private ResponseEntity<ApiErrorResponse> buildResponse(
            HttpStatus status,
            ApiErrorType type,
            String message,
            String upstreamBody,
            ServerWebExchange exchange
    ) {
        ApiErrorResponse body = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                type.name(),
                message,
                exchange.getRequest().getPath().value(),
                upstreamBody
        );
        return ResponseEntity.status(status).body(body);
    }
}
