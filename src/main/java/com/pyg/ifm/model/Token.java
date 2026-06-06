package com.pyg.ifm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public class Token {

    @NotBlank(message = "El token es obligatorio")
    private String token;

    @NotBlank(message = "El tipo de token es obligatorio")
    private String tipo; // "APP" o "USER"

    @NotNull(message = "La fecha de expiración es obligatoria")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaExpiracion;

    private boolean valido = true;
    private boolean newToken = true;

    private LocalDateTime fechaCreacion;

    private String aplicacion; // Opcional: para identificar la aplicación dueña del token

    // Constructores
    public Token() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Token(String token, String tipo, String aplicacion, LocalDateTime fechaExpiracion, boolean valido, boolean newToken, LocalDateTime fechaCreacion) {
        this();
        this.token = token;
        this.tipo = tipo;
        this.aplicacion = aplicacion;
        this.fechaExpiracion = fechaExpiracion;
        this.valido = valido;
        this.newToken = newToken;
        this.fechaCreacion = fechaCreacion;

    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isNewToken() {
        return newToken;
    }

    public void setNewToken(boolean newToken) {
        this.newToken = newToken;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    // Método para verificar si el token está expirado
    public boolean isExpirado() {
        return LocalDateTime.now().isAfter(fechaExpiracion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token1 = (Token) o;
        return Objects.equals(token, token1.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fechaExpiracion=" + fechaExpiracion +
                ", valido=" + valido +
                '}';
    }
}