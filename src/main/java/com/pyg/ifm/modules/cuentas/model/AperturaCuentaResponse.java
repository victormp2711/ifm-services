package com.pyg.ifm.modules.cuentas.model;

import lombok.Data;

@Data
public class AperturaCuentaResponse {
    private String numeroCuenta;
    private String tipoCuenta;
    private String idCliente;
    private double saldoInicial;
    private String moneda;
    private String sucursal;
    private String fechaApertura;
}
