package com.pyg.ifm.modules.models;

import lombok.Data;

@Data
public class TransactionHeader {

    // Indica inicio de la transacción (BYTEI, 5 bytes)
    private String byteI;

    // Identificación de la nueva estructura (1 byte, carácter "X")
    private String identificacionNuevaEstructura;

    // Constante "S/N" (S: Real Time, N: No Real Time)
    private String constanteRealTime;

    // Fecha de la transacción (Día, Mes, Año)
    private int diaTransaccion;
    private int mesTransaccion;
    private int anioTransaccion;

    // Hora de la transacción (Hora, Minutos, Segundos)
    private int horaTransaccion;
    private int minutosTransaccion;
    private int segundosTransaccion;

    // Código de registro (8665, 5 dígitos)
    private String codigoRegistro;

    // Usuario que realizó la transacción (10 caracteres)
    private String usuarioTransaccion;

    // Fecha de envío (Día, Mes, Año)
    private int diaEnvio;
    private int mesEnvio;
    private int anioEnvio;

    // Hora de envío (Hora, Minutos, Segundos)
    private int horaEnvio;
    private int minutosEnvio;
    private int segundosEnvio;

    // Número de identificador de la transacción (14 dígitos)
    private String numeroIdentificadorTransaccion;
}
