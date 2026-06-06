package com.pyg.ifm.modules.proveedores.model;

import lombok.Data;

@Data
public class PagoProveedorResponse {
    private String idPago;
    private String idProveedor;
    private String nombreProveedor;
    private String numeroFactura;
    private double monto;
    private String moneda;
    private String concepto;
    private String cuentaOrigen;
    private String metodoPago;
    private String fechaPago;
    private String estado;
    private String numeroComprobante;
}
