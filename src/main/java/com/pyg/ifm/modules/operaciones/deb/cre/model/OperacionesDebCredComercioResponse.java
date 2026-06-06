package com.pyg.ifm.modules.operaciones.deb.cre.model;

import lombok.Data;

@Data
public class OperacionesDebCredComercioResponse {
    private String numeroCuenta;
    private String tipoCuenta;
    private String idCliente;
    private double saldoInicial;
    private String moneda;
    private String sucursal;
    private String fechaApertura;
}
