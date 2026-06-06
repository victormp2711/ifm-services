package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class MaestroContableRequest {
    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer codigoDePais;                     // N, 3,0
    private Integer codigoDeEmpresa;                 // N, 5,0
    private Integer departamentoOSucursal;           // N, 5,0
    private Integer tipoDeCuenta;                   // N, 1,0
    private Integer subTipoDeCuenta;                // N, 2,0
    private Integer flagManejaAuxiliares;            // N, 1,0
    private Integer fechaDeCreacionDeLaCuenta;       // N, 8,0
    private Integer horaDeCreacionDeLaCuenta;        // N, 6,0
    private Integer anoMesDeLecturaRegistro;         // N, 6,0
    private Integer fechaDeLecturaDelRegistro;       // N, 8,0
    private Integer fechaDeLecturaDelRegistroConAnioAnterior; // N, 8,0
    private Integer numeroDeNivelDeLaCuentaContable; // N, 2,0

    // Campos de tipo String (TIPO = A)
    private String numeroDeCuentaContable;          // A, 35
    private String descripcionDeLaCuenta;           // A, 40
    private String flagTotalODetalle;               // A, 1
    private String tipoDeSaldo;                     // A, 1
    private String usuarioDeCreacionDeLaCuenta;      // A, 20
    private String estatusDeLaCuenta;               // A, 1
    private String indicadorDeFraudeOError;          // A, 1
    private String terminalDireccionIpONombreDeMaquina; // A, 15

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double saldoActualDeDia;                // N, 14,2
    private Double saldoInicioDia;                  // N, 14,2
    private Double saldoInicioMes;                  // N, 14,2
    private Double saldoInicioAnio;                 // N, 14,2
}