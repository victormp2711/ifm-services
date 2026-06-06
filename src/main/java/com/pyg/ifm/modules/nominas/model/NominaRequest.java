package com.pyg.ifm.modules.nominas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NominaRequest { //567 Nominas

    // Código del empleado
    private String codigoEmpleado;  // Código Interno del Empleado (A, 20)

    // Valores numéricos con precisión
    private BigDecimal sueldoBase;  // Sueldo Base del Empleado (N, 14,2)
    private BigDecimal bonificacion;  // Bonificación del Empleado (N, 14,3)

    // Anticipo
    private BigDecimal anticipo;  // Valor del Anticipo (N, 14,4)

    // Devengados
    private BigDecimal devengado1;  // Valor devengado No. 1 (N, 14,5)
    private BigDecimal devengado2;  // Valor devengado No. 2 (N, 14,6)
    private BigDecimal devengado3;  // Valor devengado No. 3 (N, 14,7)
    private BigDecimal devengado4;  // Valor devengado No. 4 (N, 14,8)
    private BigDecimal devengado5;  // Valor devengado No. 5 (N, 14,9)

    // Deducciones
    private BigDecimal deduccion1;  // Valor deducción No. 1 (N, 14,10)
    private BigDecimal deduccion2;  // Valor deducción No. 2 (N, 14,11)
    private BigDecimal deduccion3;  // Valor deducción No. 3 (N, 14,12)
    private BigDecimal deduccion4;  // Valor deducción No. 4 (N, 14,13)
    private BigDecimal deduccion5;  // Valor deducción No. 5 (N, 14,14)
    private BigDecimal deduccion6;  // Valor deducción No. 6 (N, 14,15)
    private BigDecimal deduccion7;  // Valor deducción No. 7 (N, 14,16)
    private BigDecimal deduccion8;  // Valor deducción No. 8 (N, 14,17)
    private BigDecimal deduccion9;  // Valor deducción No. 9 (N, 14,18)

    // Subtotales
    private BigDecimal subTotal1;  // Suma de todos los devengados (N, 14,19)
    private BigDecimal subTotal2;  // Suma de todas las deducciones (N, 14,20)

    // Totales
    private BigDecimal total1;  // Líquido a Pagar (N, 14,21)
    private BigDecimal total2;  // Total adicional No. 2 (N, 14,22)
    private BigDecimal total3;  // Total adicional No. 3 (N, 14,23)

    // Campos ABC
    private String abcFecha;  // Fecha de la Transacción (N, 8,0)
    private String abcHora;  // Hora de la Transacción (N, 6,0)
    private String abcUsuario;  // Usuario que Realizó la Transacción (A, 20)
    private String abcTerminal;  // Código de Terminal, Dirección IP o Nombre de Máquina (A, 15)
}