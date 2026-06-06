package com.pyg.ifm.modules.internetbanking.model;

import lombok.Data;

@Data
public class SolicitudInternetBankingRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoIdClienteIdCliente;          // A, 18
    private String tipoDeIdDelCliente;              // A, 3
    private String idCliente;                       // A, 15
    private String nombreCompletoDelCliente;        // A, 70
    private String codigoDeClienteDeLaInstitucion; // A, 15
    private String numeroDeCuenta;                  // A, 20
    private String estatusDeLaCuenta;               // A, 1
    private String codigoDeProducto;                // A, 5
    private String codigoDeSubproducto;             // A, 4
    private String tipoCuenta;                      // A, 2
    private String usuario;                         // A, 20
    private String terminalDireccionIp;             // A, 15
    private String ciudadDeLaSucursalOficinaDondeSeSolicito; // A, 20
    private String medioOCanalDeSolicitud;           // A, 10
    private String reversa;                         // A, 1
    private String clienteVip;                      // A, 1

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer fechaDeSolicitud;                // N, 8,0
    private Integer horaDeSolicitud;                 // N, 6,0
    private Integer sucursalOficinaDondeSolicito;    // N, 5,0
    private Integer tipoDeServicioSolicitado;       // N, 5,0
}