package com.pyg.ifm.modules.creditos.model;

import lombok.Data;

@Data
public class CambioCreditoRequest {
    // Campos de tipo String (TIPO = A)
    private String entidad;                     // A, 4
    private String tipoIdNoIdentificacion;      // A, 18
    private String codigoDeCliente;             // A, 15
    private String codigoDeProducto;           // A, 5
    private String codigoDeTrx;                // A, 5
    private String usuario;                    // A, 20
    private String terminalDireccionIpONombreDeMaquina; // A, 15
    private String datoAnterior;                // A, 60
    private String datoPosterior;               // A, 60

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer puestoDelUsuarioQueAprobo; // N, 5
    private Integer fecha;                     // N, 8,0
    private Integer hora;                      // N, 6,0
}