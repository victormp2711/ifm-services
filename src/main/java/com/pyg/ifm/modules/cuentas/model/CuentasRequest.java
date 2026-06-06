package com.pyg.ifm.modules.cuentas.model;

import lombok.Data;

@Data
public class CuentasRequest {
    // Campos en el orden original de la lista
    private String idClienteRfc;                  // A
    private String codigoDeEntidadCompania;        // A
    private String codigoDeTransaccion;            // A
    private Integer sucursalTransaccion;           // N
    private String codigoDeProducto;              // A
    private String numeroDeTrxPtId;                // A
    private Integer codRespuesta;                  // N
    private String tipoPersona;                    // A
    private String reverso;                        // A
    private Integer fechaTrx;                      // N
    private Integer horaTrx;                       // N
    private String tipoDeSucursal;                 // A
    private String monedaTrx;                      // A
    private Double montoTotalTrx;                  // N (monto)
    private Double montoEfectivo;                  // N (monto)
    private Double montoChequePropio;              // N (monto)
    private Double montoChequeAjeno;               // N (monto)
    private String numeroDeCuentaOrigen;           // A
    private String numeroDeCuentaDestino;          // A
    private String canalOMedio;                    // A
    private Integer noDeDocumentoCheque;           // N
    private String tipoDeChequera;                 // A
    private String flagEmpleadoCtaOrigen;          // A
    private String flagEmpleadoCtaDestino;         // A
    private String idDeEmpleadoRutNitRfcRif;       // A
    private String debitoCreditoUOtras;             // A
    private String estatusDeCtaOProducto;           // A
    private String signoValor;                     // A
    private Double saldoDisponible;                // N (monto)
    private String localidad;                       // A
    private Integer fechaAperturaCuenta;           // N
    private String idTerminal;                     // A
    private String codClienteRimOrigen;            // A
    private String codClienteRimDestino;           // A
    private Integer sucursalAperturaCuentaOrigen;   // N
    private Integer sucursalAperturaCuentaDestino; // N
    private String codigoDeUsuario;                // A
    private String codFuncionarioEmpleado;          // A
    private Double montoSobregiroAutorizado;        // N (monto)
    private String indicadorDeSobregiro;            // A
    private String flagCuentaVip;                   // A
    private String flagCuentaRegistradaInternet;    // A
    private String nombreClienteTitularCtaOrigen;   // A
    private String nombreClienteTitularCtaDestino;  // A
    private String tipoPagoDeServicio;             // A
}