package com.pyg.ifm.modules.tarjetas.model;

import lombok.Data;

@Data
public class SolicitudTarjetaDebitoRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoIdClienteIdCliente;          // A, 18
    private String tipoDeIdDelCliente;              // A, 3
    private String idCliente;                       // A, 15
    private String nombreCompletoDelCliente;        // A, 70
    private String numeroDeCuentaAsociarNo1;        // A, 20
    private String fechaDeSolicitud;                // A, 6,0 (Nota: En la lista aparece como N, pero el código 9122 tiene tipo N, pero en el nombre dice "Fecha de Solicitud", se asume String)
    private String sucursalOficinaDondeSolicito;    // A, 15
    private String usuario;                         // A, 20
    private String terminalDireccionIp;             // A, 15
    private String nacionalidad;                    // A, 3
    private String numeroDeSeguroSocial;             // A, 15
    private String noIdentificacionTributaria;       // A, 15
    private String ciudadDeExpedicionDeLaId;         // A, 20
    private String direccionDeDomicilio;            // A, 50
    private String localidadCiudadDireccionDomicilio; // A, 20
    private String nombreDeEmpresaDondeTrabaja;      // A, 30
    private String direccionDeTrabajo;              // A, 50
    private String localidadCiudadDireccionTrabajo; // A, 20
    private String telefonoResidencia;              // A, 12
    private String telefonoOficina;                 // A, 12
    private String telefonoMovil;                   // A, 12
    private String profesionUOficio;                // A, 5
    private String estadoCivil;                     // A, 1
    private String nombreDelConyuge;                // A, 50
    private String telefonoMovilDelConyuge;          // A, 12
    private String clienteVip;                      // A, 1
    private String codigoDeClienteDeLaInstitucion; // A, 15

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer numeroDeSolicitud;              // N, 8,0
    private Integer horaDeSolicitud;                 // N, 8,0
    private Integer fechaDeExpedicionDeLaId;         // N, 8,0
    private Integer fechaInicioDeRelacionLaboralActual; // N, 8,0
    private Integer fechaDeNacimientoConstitucion;   // N, 8,0
    private Integer fechaNacimientoDelConyuge;        // N, 8,0
}