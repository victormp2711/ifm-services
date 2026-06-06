package com.pyg.ifm.exception;

import java.time.Instant;

public record ApiErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String type,
        String message,
        String path,
        String upstreamBody
) {
}
