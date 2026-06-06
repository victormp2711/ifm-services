package com.pyg.ifm.modules.contable.model;

import lombok.Data;

import java.util.List;

@Data
public class AsientoContableRequest {
    private String idMaestro;
    private String fechaAsiento;
    private String concepto;
    private List<PartidaContable> partidas;
}
