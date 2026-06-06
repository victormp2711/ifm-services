package com.pyg.ifm.modules.tarjetas.model;

import lombok.Data;

@Data
public class SolicitudTarjetaRequest {
    private String idCliente;
    private String tipoTarjeta;
    private String tipoCuenta;
    private String numeroCuenta;
    private String categoriaTarjeta;
}
