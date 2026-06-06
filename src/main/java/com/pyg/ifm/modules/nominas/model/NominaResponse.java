package com.pyg.ifm.modules.nominas.model;

import lombok.Data;

@Data
public class NominaResponse {
    private String idNomina;
    private String idEmpresa;
    private String periodo;
    private String tipoNomina;
    private String estado;
    private String fechaCreacion;
}
