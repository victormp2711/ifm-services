package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class ConsultaCuentasContablesRequest {
    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer codigoDePais;                     // N, 3,0
    private Integer codigoDeEmpresa;                 // N, 5,0
    private Integer departamento;                    // N, 5,0
    private Integer tipoDeConsulta;                 // N, 2,0
    private Integer tipoDeCuenta;                   // N, 1,0
    private Integer subTipoDeCuenta;                // N, 2,0
    private Integer fechaDeLaConsultaALacuenta;      // N, 8,0
    private Integer horaDeLaConsultaALacuenta;       // N, 6,0

    // Campos de tipo String (TIPO = A)
    private String numeroDeCuentaContable;          // A, 35
    private String descripcionDeLaCuenta;           // A, 40
    private String flagTotalODetalle;               // A, 1
    private String tipoDeSaldo;                     // A, 1
    private String usuarioQueConsultoLaCuenta;      // A, 20
    private String estatusDeLaCuenta;               // A, 1
    private String indicadorDeFraudeOError;          // A, 1
    private String terminalDireccionIpONombreDeMaquina; // A, 15

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double saldoActualDeDia;                // N, 14,2
}