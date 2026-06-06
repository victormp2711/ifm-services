package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class CuentaContableRequest {
    private String codigoCuenta;
    private String nombreCuenta;
    private String tipoCuenta;
    private String nivel;
    private String naturaleza;
}
