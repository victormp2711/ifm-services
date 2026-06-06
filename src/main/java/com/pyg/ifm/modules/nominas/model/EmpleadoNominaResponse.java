package com.pyg.ifm.modules.nominas.model;

import lombok.Data;

@Data
public class EmpleadoNominaResponse {
    private String idRegistro;
    private String idNomina;
    private String idEmpleado;
    private double salarioBase;
    private double bonos;
    private double deducciones;
    private double salarioNeto;
    private String estado;
}
