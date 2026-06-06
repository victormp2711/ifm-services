package com.pyg.ifm.modules.tarjetas.model;

import lombok.Data;

@Data
public class TransaccionTarjetaResponse {
    private String idTransaccion;
    private String numeroTarjetaEnmascarado;
    private String numeroComercio;
    private double monto;
    private String moneda;
    private String tipoTransaccion;
    private String descripcion;
    private String fechaTransaccion;
    private String estado;
    private String codigoAutorizacion;
}
