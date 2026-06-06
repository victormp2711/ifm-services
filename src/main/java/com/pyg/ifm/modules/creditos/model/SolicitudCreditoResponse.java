package com.pyg.ifm.modules.creditos.model;

import lombok.Data;

@Data
public class SolicitudCreditoResponse {
    private String idSolicitud;
    private String idCliente;
    private double montoSolicitado;
    private int plazoMeses;
    private String tipoCredito;
    private String estado;
    private String fechaSolicitud;
}