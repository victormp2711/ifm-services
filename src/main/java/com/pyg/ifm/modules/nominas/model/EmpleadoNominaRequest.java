package com.pyg.ifm.modules.nominas.model;

import lombok.Data;

@Data
public class EmpleadoNominaRequest {
    private String idNomina;
    private String idEmpleado;
    private double salarioBase;
    private double bonos;
    private double deducciones;
}
