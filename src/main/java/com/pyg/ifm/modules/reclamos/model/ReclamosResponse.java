package com.pyg.ifm.modules.reclamos.model;

import lombok.Data;

@Data
public class ReclamosResponse {
    private String idReclamo;
    private String idCliente;
    private String tipoReclamo;
    private String descripcion;
    private String categoria;
    private String prioridad;
    private String canalIngreso;
    private String estado;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String numeroTicket;
}
