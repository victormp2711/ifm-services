package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class MaestroContableResponse {
    private String idMaestro;
    private String idEmpresa;
    private String ejercicioFiscal;
    private String periodo;
    private String estado;
    private String fechaCreacion;
}
