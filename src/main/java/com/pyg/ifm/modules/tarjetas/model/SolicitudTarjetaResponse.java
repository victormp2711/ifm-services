package com.pyg.ifm.modules.tarjetas.model;

import lombok.Data;

@Data
public class SolicitudTarjetaResponse {
    private String idSolicitud;
    private String idCliente;
    private String tipoTarjeta;
    private String tipoCuenta;
    private String numeroCuenta;
    private String categoriaTarjeta;
    private String estado;
    private String fechaSolicitud;
    private String numeroTarjetaEnmascarado;
}
