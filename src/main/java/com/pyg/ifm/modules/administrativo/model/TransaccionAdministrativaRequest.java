package com.pyg.ifm.modules.administrativo.model;

import lombok.Data;

@Data
public class TransaccionAdministrativaRequest {
    private String tipoTransaccion;
    private String descripcion;
    private String usuario;
    private double monto;
    private String referencia;
}
