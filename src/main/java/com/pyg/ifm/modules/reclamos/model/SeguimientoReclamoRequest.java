package com.pyg.ifm.modules.reclamos.model;

import lombok.Data;

@Data
public class SeguimientoReclamoRequest {
    private String idReclamo;
    private String comentario;
    private String estado;
}
