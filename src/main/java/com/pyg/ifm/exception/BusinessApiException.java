package com.pyg.ifm.exception;

import org.springframework.http.HttpStatus;

/**
 * Error de negocio devuelto por el servicio externo (HTTP 4xx).
 * No debe abrir el circuit breaker.
 */
public class BusinessApiException extends RuntimeException {

    private final HttpStatus status;
    private final String upstreamBody;

    public BusinessApiException(HttpStatus status, String message, String upstreamBody, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.upstreamBody = upstreamBody;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getUpstreamBody() {
        return upstreamBody;
    }

    public ApiErrorType getErrorType() {
        return ApiErrorType.BUSINESS;
    }
}
