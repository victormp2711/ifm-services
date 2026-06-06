package com.pyg.ifm.modules.nominas.model;

import lombok.Data;

@Data
public class PlanillaResponse {
    private String idPlanilla;
    private String idNomina;
    private String periodo;
    private double totalSalarios;
    private double totalBonos;
    private double totalDeducciones;
    private double totalNeto;
    private String fechaGeneracion;
}
