package com.pyg.ifm.modules.cuentas.model;

import lombok.Data;

@Data
public class CuentasMonetariasRequest {  // 345
    // Campos de tipo String (TIPO = A)
    private String idClienteRfc;                     // A, 14
    private String codigoDeEntidadCompania;           // A, 4
    private String codigoDeTransaccion;               // A, 6
    private String codigoDeProducto;                 // A, 2
    private String numeroDeTrxPtId;                   // A, 11
    private String tipoPersona;                       // A, 1
    private String reverso;                           // A, 1
    private String tipoDeSucursal;                    // A, 4
    private String monedaTrx;                         // A, 3
    private String numeroDeCuentaOrigen;              // A, 25
    private String numeroDeCuentaDestino;             // A, 25
    private String canalOMedio;                       // A, 3
    private String tipoDeChequera;                    // A, 1
    private String flagEmpleadoCtaOrigen;             // A, 1
    private String flagEmpleadoCtaDestino;            // A, 1
    private String idDeEmpleadoRutNitRfcRif;          // A, 15
    private String debitoCreditoUOtras;                // A, 1
    private String estatusDeCtaOProducto;              // A, 1
    private String signoValor;                        // A, 1
    private String localidad;                          // A, 30
    private String idTerminal;                        // A, 10
    private String codClienteRimOrigen;               // A, 12
    private String codClienteRimDestino;              // A, 12
    private String codigoDeUsuario;                   // A, 20
    private String codFuncionarioEmpleado;             // A, 20
    private String indicadorDeSobregiro;               // A, 2
    private String flagTipoCuentaVip;                 // A, 2
    private String flagCuentaRegistradaInternet;       // A, 1
    private String nombreClienteTitularCtaOrigen;      // A, 40
    private String nombreClienteTitularCtaDestino;     // A, 40
    private String tipoPagoDeServicio;                // A, 6

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer sucursalTransaccion;              // N, 5,0
    private Integer codRespuesta;                     // N, 4,0
    private Integer fechaTrx;                         // N, 8,0
    private Integer horaTrx;                          // N, 6,0
    private Integer noDeDocumentoCheque;              // N, 12,0
    private Integer fechaAperturaCuenta;              // N, 8,0
    private Integer sucursalAperturaCuentaOrigen;      // N, 5,0
    private Integer sucursalAperturaCuentaDestino;    // N, 5,0

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double montoTotalTrx;                     // N, 15,2
    private Double montoEfectivo;                     // N, 15,2
    private Double montoChequePropio;                 // N, 15,2
    private Double montoChequeAjeno;                  // N, 15,2
    private Double saldoDisponible;                   // N, 14,2
    private Double montoSobregiroAutorizado;           // N, 15,2
}