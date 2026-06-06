package com.pyg.ifm.exception;

import org.springframework.http.HttpStatus;

/**
 * Fallo de infraestructura: timeout, conexión rechazada o HTTP 5xx del servicio externo.
 */
public class UpstreamApiException extends RuntimeException {

    private final HttpStatus status;
    private final String upstreamBody;
    private final ApiErrorType errorType;

    private UpstreamApiException(
            HttpStatus status,
            String message,
            String upstreamBody,
            ApiErrorType errorType,
            Throwable cause
    ) {
        super(message, cause);
        this.status = status;
        this.upstreamBody = upstreamBody;
        this.errorType = errorType;
    }

    public static UpstreamApiException fromUpstream(HttpStatus status, String message, String upstreamBody, Throwable cause) {
        return new UpstreamApiException(status, message, upstreamBody, ApiErrorType.UPSTREAM, cause);
    }

    public static UpstreamApiException circuitOpen(String circuitBreakerName) {
        return new UpstreamApiException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Servicio externo no disponible (circuit breaker abierto: " + circuitBreakerName + ")",
                null,
                ApiErrorType.CIRCUIT_OPEN,
                null
        );
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getUpstreamBody() {
        return upstreamBody;
    }

    public ApiErrorType getErrorType() {
        return errorType;
    }
}
