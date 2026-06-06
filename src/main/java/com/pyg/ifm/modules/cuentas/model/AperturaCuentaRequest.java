package com.pyg.ifm.modules.cuentas.model;

import lombok.Data;

@Data
public class AperturaCuentaRequest {

    // Datos básicos de la transacción
    private String idClienteRfc;
    private String fechaAperturaCuenta;
    private String horaTrx;
    private String tipoPersona;

    // Datos de la cuenta
    private String numeroCuentaOrigen;
    private String codigoProducto;
    private String codigoSubproducto;
    private String sucursalTransaccion;
    private String idTerminal;
    private String codigoUsuario;
    private Boolean flagTipoCuentaVip;

    // Datos del cliente titular
    private String nombreClienteTitularCtaOrigen;
    private String direccionDomicilio;
    private String telefonoResidencia;
    private String telefonoOficina;
    private String telefonoOtro;
    private String correoElectronicoEmail;
    private String segmentoCliente;
    private String fechaNacimientoConstitucion;
    private String lugarNacimientoConstitucion;
    private String sexoCuentahabiente;
    private String estadoCivilCuentahabiente;
    private String actividadEconomica;

    // Datos adicionales
    private String codFuncionarioEmpleado;
    private String codClienteRimOrigen;
    private String usoFuturo1;
    private String usoFuturo2;
}