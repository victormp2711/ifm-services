package com.pyg.ifm.modules.internetbanking.model;

import lombok.Data;

@Data
public class SolicitudInternetBankingResponse {
    private String idSolicitud;
    private String idCliente;
    private String tipoCuenta;
    private String numeroCuenta;
    private String correoElectronico;
    private String estado;
    private String fechaSolicitud;
    private String tokenAcceso;
}
