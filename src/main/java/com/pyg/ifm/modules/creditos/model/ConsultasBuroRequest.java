package com.pyg.ifm.modules.creditos.model;

import lombok.Data;

@Data
public class ConsultasBuroRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoIdClienteIdCliente;  // A, 18
    private String tipoDeIdDelCliente;      // A, 3
    private String idCliente;               // A, 15
    private String usuario;                 // A, 20
    private String codigoDeClienteDeLaInstitucion; // A, 15

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer fechaAplicacion;        // N, 8,0
    private Integer hora;                  // N, 6,0
    private Integer idBuroDeCredito;        // N, 3,0
}