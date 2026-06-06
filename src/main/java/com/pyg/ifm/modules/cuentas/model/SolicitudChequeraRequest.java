package com.pyg.ifm.modules.cuentas.model;

import lombok.Data;

@Data
public class SolicitudChequeraRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoIdClienteIdCliente;          // A, 18
    private String tipoDeIdDelCliente;              // A, 3
    private String idCliente;                       // A, 15
    private String nombreCompletoDelCliente;        // A, 70
    private String codigoDeClienteDeLaInstitucion; // A, 15
    private String usuario;                         // A, 20
    private String ciudadDeLaSucursalOficinaDondeSeSolicito; // A, 20
    private String empleado;                        // A, 1
    private String tipoDeChequera;                 // A, 1
    private String terminalDireccionIp;             // A, 15
    private String medioOCanalDeSolicitud;           // A, 10
    private String reversa;                         // A, 1
    private String monedaDeLaCuenta;                // A, 3
    private String usuarioDelCliente;               // A, 20
    private String clienteVip;                      // A, 1

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer numeroDeSolicitud;              // N, 10,0
    private Integer noDeChequerasASolicitar;        // N, 3,0
    private Integer fechaDeAperturaDeLaCuenta;      // N, 8,0
    private Integer noCuenta;                       // N, 20
    private Integer sucursalOficinaDondeSolicito;   // N, 5,0
    private Integer fechaDeSolicitud;                // N, 8,0
    private Integer horaDeSolicitud;                 // N, 6,0
}