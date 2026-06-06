package com.pyg.ifm.modules.novedades.model;

import lombok.Data;

@Data
public class NovedadesRequest { //318 Variables novedades
    // ========== Datos del Cliente ==========
    private String codClienteRimOrigen; // Código Cliente / RIM Origen
    private String nombreClienteTitularCtaOrigen; // Nombre Cliente Titular Cta Origen
    private String idClienteRfc; // ID Cliente/RFC
    private String idClienteRfcRecibeChequera; // ID Cliente/RFC Recibe Chequera

    // ========== Datos de la Cuenta ==========
    private String numeroCuentaOrigen; // Número de Cuenta Origen
    private String estatusCtaProducto; // Estatus Cta o Producto
    private String flagEmpleadoCtaOrigen; // Flag Empleado Cta Origen
    private String sucursalAperturaCuentaOrigen; // Sucursal Apertura Cuenta Origen
    private String fechaAperturaCuenta; // Fecha Apertura Cuenta
    private Double saldoDisponible; // Saldo Disponible

    // ========== Datos de la Transacción ==========
    private String codigoTransaccion; // Código de Transacción
    private String canalMedio; // Canal o Medio
    private String fechaTrx; // Fecha Trx
    private String horaTrx; // Hora Trx
    private String idTerminal; // ID Terminal
    private String codigoUsuario; // Código de Usuario
    private String nombreUsuario; // Nombre de Usuario
    private String tipoUsuario; // Tipo de Usuario
    private String numeroReferencia; // Número de Referencia

    // ========== Datos del Producto ==========
    private String codigoProducto; // Código de Producto
    private String codigoSubproducto; // Código de Subproducto

    // ========== Datos de Chequera ==========
    private String noChequeInicial; // No Cheque Inicial
    private String noChequeFinal; // No Cheque Final
    private String tipoChequera; // Tipo de Chequera
    private Integer noChequeras; // No. Chequeras
    private Integer noChequesActivos; // No. Cheques Activos

    // ========== Datos de Ubicación ==========
    private String direccionIpCallerId; // Dirección IP/Caller ID
    private String sucursalTransaccion; // Sucursal Transacción
    private String localidad; // Localidad
    private String tipoSucursal; // Tipo de Sucursal

    // ========== Datos del Empleado ==========
    private String codFuncionarioEmpleado; // Cod Funcionario/Empleado
    private String tipoEmpleado; // Tipo de Empleado

    // ========== Datos de Fraude ==========
    private String identifTrxFraude; // Identif Trx Fraude
    private String indicadorFraude; // Indicador de Fraude
    private String origenAlerta; // Origen Alerta

    // ========== Datos de Cambios ==========
    private String signoValor; // Signo Valor
    private Double valorAnteriorCambio; // Valor Anterior al Cambio
    private Double valorPosteriorCambio; // Valor Posterior al Cambio

    // ========== Datos Adicionales ==========
    private String isp; // ISP (Internet Service Provider)
    private String tipoNovedad; // Tipo de Novedad
    private String usoFuturo1; // Uso Futuro 1
    private String usoFuturo2; // Uso Futuro 2
}