package com.pyg.ifm.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FallbackResponse {
    private String id;          // UUID único
    private String timestamp;   // Fecha completa (ISO-8601)
    private String message;     // Mensaje genérico

    // Constructor, getters y setters
    public FallbackResponse(String message) {
        this.id = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.message = message;
    }

    // Getters y setters (opcional, si usas Lombok, puedes omitirlos)
    public String getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}