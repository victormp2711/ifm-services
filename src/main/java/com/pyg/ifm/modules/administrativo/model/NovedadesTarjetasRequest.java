package com.pyg.ifm.modules.administrativo.model;

import lombok.Data;

@Data
public class NovedadesTarjetasRequest {
    private String idCliente;
    private String noTarjetaEncriptadoSha256;
    private Integer codigoDeTransaccion;
    private Integer horaTrxAdq;
    private Integer fechaTrxAdq;
    private String idTerminal;
    private String datoAnterior;
    private String datoPosterior;
    private String codigoCioAgenciaOficinaOrigen;
    private String acfUsuario;
}
