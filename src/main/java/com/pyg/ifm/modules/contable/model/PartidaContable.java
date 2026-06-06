package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class PartidaContable {
    private String idCuenta;
    private String descripcion;
    private double debe;
    private double haber;
}
