package com.pyg.ifm.modules.novedades.model;

import lombok.Data;

@Data
public class ReintegroDeGastosRequest {
    // Campos de tipo String (TIPO = A)
    private String entidad;                          // A, 4
    private String codigoDeEmpleado;                 // A, 20
    private String motivoDelGasto;                   // A, 50
    private String monedaDelGasto;                   // A, 3
    private String descripcionDelGasto;              // A, 60
    private String codigoEmpleadoQueAutorizoElGasto; // A, 20
    private String puestoEmpleadoQueAutorizoElGasto; // A, 25
    private String usuario;                          // A, 20
    private String terminalDireccionIpONombreDeMaquina; // A, 15

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer fechaDelGasto;                   // N, 8,0
    private Integer codigoMotivoDelGasto;            // N, 5,0
    private Integer fechaDeReintegroDelGasto;         // N, 8,0
    private Integer fecha;                           // N, 8,0
    private Integer hora;                            // N, 6,0

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double montoDelGastoMn;                  // N, 14,2
    private Double montoDelReintegroMn;              // N, 14,2
}