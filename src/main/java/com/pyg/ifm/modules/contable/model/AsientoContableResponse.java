package com.pyg.ifm.modules.contable.model;

import lombok.Data;

import java.util.List;

@Data
public class AsientoContableResponse {
    private String idAsiento;
    private String idMaestro;
    private String fechaAsiento;
    private String concepto;
    private String estado;
    private String fechaCreacion;
    private List<PartidaContable> partidas;
}
