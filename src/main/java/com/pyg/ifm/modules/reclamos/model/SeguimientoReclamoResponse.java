package com.pyg.ifm.modules.reclamos.model;

import lombok.Data;

@Data
public class SeguimientoReclamoResponse {
    private String idSeguimiento;
    private String idReclamo;
    private String comentario;
    private String estado;
    private String fechaSeguimiento;
}
