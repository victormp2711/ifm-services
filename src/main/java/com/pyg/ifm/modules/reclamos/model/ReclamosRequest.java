package com.pyg.ifm.modules.reclamos.model;

import lombok.Data;

@Data
public class ReclamosRequest {
    private String codigoDeReclamo;
    private String numeroDelReclamo;
    private Integer sucursalDeReclamo;
    private Integer fechaDelReclamo;
    private Integer horaDelReclamo;
    private String medioOCanalDelReclamo;
    private Integer codigoDeEvento;
    private String idDelCliente;
    private String ctaTarjetaNoProducto;
    private Integer fechaTransaccion;
    private Integer horaTransaccion;
    private Double montoDeLaTransaccion;
    private String identificacionTrxNoAutorizacion;
    private String codigoDeRespuesta;
    private String resultadoDelReclamo;
    private Integer codigoDelResultado;
    private String detalleDeLaInvestigacionDelReclamo;
}
