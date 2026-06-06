package com.pyg.ifm.modules.operaciones.deb.cre.model;

import lombok.Data;

@Data
public class OperacionesDebCredComercio {
    // Campos numéricos (N)
    private int acfCodTrx; // N, 2.0
    private long acfFechaTrx; // N, 8.0
    private int acfHoraTrx; // N, 6.0
    private long acfFechaAplicacion; // N, 8.0
    private double acfMontoEnMonedaLocal; // N, 12.2
    private double acfMontoOriginalTrx; // N, 12.2
    private double acfSaldoDisponibleEnMonedaTrx; // N, 12.2
    private double acfCupoTarjetaEnMonedaTrx; // N, 12.0

    // Campos alfabéticos (A)
    private String acfIdCliente; // A, 15
    private String acfMotivoConcepto; // A, 4
    private String acfCodRpta; // A, 3
    private String acfAutorizacion; // A, 6
    private String acfReverso; // A, 1
    private String acfReferencia1; // A, 25
    private String acfReferencia2; // A, 25
    private String acfReferencia3; // A, 25
    private String acfIdTerminalDireccionIP; // A, 15
    private String acfUsuario; // A, 20
    private String acfCodigoCIOAgenciaOficinaOrigen; // A, 15
    private String acfCodigoSupervisorAnalista; // A, 15
    private String acfDebitoCredito; // A, 2
    private String acfEstadoSituacionBloqueoTarjeta; // A, 2
    private String acfCicloTarjeta; // A, 2
}
