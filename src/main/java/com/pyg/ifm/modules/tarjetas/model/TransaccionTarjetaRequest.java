package com.pyg.ifm.modules.tarjetas.model;

import lombok.Data;

@Data
public class TransaccionTarjetaRequest {
    private String numeroTarjeta;
    private String numeroComercio;
    private double monto;
    private String moneda;
    private String tipoTransaccion;
    private String descripcion;
}
