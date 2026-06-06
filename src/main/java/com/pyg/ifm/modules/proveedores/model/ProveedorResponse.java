package com.pyg.ifm.modules.proveedores.model;

import lombok.Data;

@Data
public class ProveedorResponse {
    private String idProveedor;
    private String nombre;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private String fechaRegistro;
    private String estado;
}
