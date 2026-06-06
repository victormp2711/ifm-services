package com.pyg.ifm.modules.creditos.model;

import lombok.Data;

@Data
public class SolicitudCreditoRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoIdClienteIdCliente;          // A, 18
    private String tipoDeIdDelCliente;              // A, 3
    private String idCliente;                       // A, 15
    private String tipoDePersona;                   // A, 1
    private String tipoDeSolicitud;                 // A, 4
    private String usuario;                         // A, 20
    private String promotorOFuncionario;            // A, 15
    private String primerNombreCliente;             // A, 12
    private String segundoNombreCliente;            // A, 12
    private String primerApellidoCliente;           // A, 12
    private String segundoApellidoCliente;          // A, 12
    private String nombreCompletoDelCliente;        // A, 70
    private String nacionalidad;                    // A, 3
    private String numeroDeSeguroSocial;             // A, 15
    private String noIdentificacionTributaria;       // A, 15
    private String ciudadDeExpedicionDeLaId;         // A, 20
    private String direccionDeDomicilio;            // A, 50
    private String localidadCiudadDireccionDomicilio; // A, 20
    private String nombreDeEmpresaDondeTrabaja;      // A, 30
    private String direccionDeTrabajo;              // A, 50
    private String cargoQueDesempenia;              // A, 20
    private String localidadCiudadDireccionTrabajo; // A, 20
    private String telefonoResidencia;              // A, 12
    private String telefonoOficina;                 // A, 12
    private String telefonoMovil;                   // A, 12
    private String profesionUOficio;                // A, 5
    private String nombreDelConyuge;                // A, 50
    private String telefonoMovilDelConyuge;          // A, 12
    private String codigoDeTipoDeProducto;          // A, 5
    private String statusDeSolicitud;                // A, 1
    private String monedaDeLaCuenta;                // A, 3
    private String usuarioAprobador;                 // A, 20
    private String codigoDeRespuesta;               // A, 3
    private String descripcionDeRespuesta;           // A, 80
    private String codigoDeActividadEconomica;        // A, 5
    private String medioOCanalDeSolicitud;           // A, 10
    private String empleado;                         // A, 1
    private String terminalDireccionIp;             // A, 15

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer numeroDeSolicitudDeCredito;      // N, 8,0
    private Integer fechaDeExpedicionDeLaId;         // N, 8,0
    private Integer fechaAplicacion;                  // N, 8,0
    private Integer hora;                            // N, 6,0
    private Integer sucursalOficinaDondeSolicito;    // N, 5,0
    private Integer fechaInicioDeRelacionLaboralActual; // N, 8,0
    private Integer fechaDeNacimientoConstitucion;   // N, 8,0
    private Integer fechaNacimientoDelConyuge;        // N, 8,0
    private Integer anoMesDeLecturaRegistro;         // N, 6,0

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double montoSolicitado;                  // N, 12,2
    private Double montoAprobado;                    // N, 14,2
}