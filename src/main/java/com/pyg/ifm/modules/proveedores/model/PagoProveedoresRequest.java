package com.pyg.ifm.modules.proveedores.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class PagoProveedoresRequest { //582 Pagos a Proveedores

    // Código de Entidad
    private String entidad;  // A, 4

    // Código de Tercera Parte / Proveedor
    private String codigoTerceraParte;  // A, 15

    // Nombre Business as DBA
    private String nombreBusinessDBA;  // A, 40

    // Razón Social
    private String razonSocial;  // A, 30

    // Fecha de Pago
    private LocalDate fechaPago;  // N, 8,0

    // Hora de Pago
    private LocalTime horaPago;  // N, 6,0

    // Moneda del Pago
    private String monedaPago;  // A, 3

    // Monto del Pago
    private BigDecimal montoPago;  // N, 14,2

    // No. Factura que se Paga
    private String numeroFactura;  // A, 15

    // Concepto o Descripción de la Factura
    private String conceptoFactura;  // A, 60

    // Forma de Pago (C-Cheque, T-Transferencia)
    private String formaPago;  // A, 1

    // Código de Empleado que Autorizó
    private String codigoEmpleadoAutorizo;  // A, 20

    // No. Orden de Compra Relacionada
    private String numeroOrdenCompra;  // A, 15

    // Código de Presupuesto Relacionado
    private String codigoPresupuesto;  // A, 20

    // Código de Empleado que Realizó el Cheque o Transferencia
    private String codigoEmpleadoRealizo;  // A, 20

    // Cuenta Destino de la Transferencia
    private String cuentaDestino;  // A, 15

    // No. De Cheque
    private String numeroCheque;  // A, 15

    // Nombre de la Persona que Recibió Cheque
    private String nombrePersonaRecibioCheque;  // A, 50

    // No. De Identificación de la Persona que Recibió Cheque
    private String identificacionPersonaRecibioCheque;  // A, 15

    // Usuario
    private String usuario;  // A, 20

    // Terminal, Dirección IP o Nombre de Máquina
    private String terminal;  // A, 15
}
