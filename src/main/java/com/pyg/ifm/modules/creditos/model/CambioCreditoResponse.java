package com.pyg.ifm.modules.creditos.model;

import lombok.Data;

@Data
public class CambioCreditoResponse {
    private String idCredito;
    private double montoAnterior;
    private double nuevoMonto;
    private int plazoAnterior;
    private int nuevoPlazo;
    private String estado;
    private String fechaCambio;
}