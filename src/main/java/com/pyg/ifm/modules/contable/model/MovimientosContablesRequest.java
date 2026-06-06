package com.pyg.ifm.modules.contable.model;

import lombok.Data;

@Data
public class MovimientosContablesRequest {
    // Campos de tipo String (TIPO = A)
    private String tipoDeDocumento;                     // A, 10
    private String codigoDeFuente;                     // A, 5
    private String usuarioQueIngresoDocumento;        // A, 20
    private String usuarioQueAutorizoDocumento;        // A, 20
    private String idTerminalDondeSeIngresoDocumento; // A, 12
    private String idTerminalDondeSeAutorizoDocumento; // A, 12
    private String flagPartidaAutomatica;               // A, 1
    private String periodoContable;                    // A, 9
    private String numeroDeCuentaContable;             // A, 35
    private String flagDebitoOCredito;                 // A, 1
    private String tipoDeSaldo;                        // A, 1
    private String descripcionDeLaCuenta;              // A, 40
    private String estatusDeLaCuenta;                  // A, 1
    private String cuentaDeTotalOCuentaPadre;          // A, 35
    private String cuentaDeMayor;                       // A, 10
    private String indicadorDeFraudeOError;             // A, 1

    // Campos de tipo Integer (TIPO = N, sin decimales)
    private Integer numeroDeDocumento;                 // N, 14,0
    private Integer fechaValorDeContabilizacion;        // N, 8,0
    private Integer fechaDeActualizacion;               // N, 8,0
    private Integer horaDeActualizacion;               // N, 6,0
    private Integer fechaDeOperacion;                   // N, 8,0
    private Integer horaDeOperacion;                    // N, 6,0
    private Integer codigoDePais;                      // N, 3,0
    private Integer codigoDeEmpresa;                   // N, 5,0
    private Integer departamentoOSucursal;              // N, 5,0
    private Integer numeroDeLineaCorrelativaEnElDocumento; // N, 5,0
    private Integer ultimoCorrelativoEnElDocumento;    // N, 5,0
    private Integer tipoDeCuenta;                      // N, 2,0
    private Integer subTipoDeCuenta;                   // N, 2,0
    private Integer reversa;                           // N, 1,0
    private Integer numeroDeNivelesDeLaCuenta;         // N, 2,0

    // Campos de tipo Double (TIPO = N, con decimales)
    private Double totalDelDocumento;                  // N, 14,2
    private Double totalDePartidaSumasIgualesDebitoCredito; // N, 14,2
    private Double montoOperacion;                     // N, 14,2
    private Double saldoActual;                        // N, 14,2
    private Double saldoInicioDia;                     // N, 14,2
    private Double saldoInicioMes;                     // N, 14,2
    private Double saldoInicioAnio;                    // N, 14,2
}