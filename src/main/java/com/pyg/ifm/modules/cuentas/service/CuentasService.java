package com.pyg.ifm.modules.cuentas.service;

import com.pyg.ifm.modules.cuentas.model.*;
import reactor.core.publisher.Mono;

public interface CuentasService {
    Mono<AperturaCuentaResponse> aperturaCuenta(AperturaCuentaRequest request);

    Mono<VariableCuentasResponse> variableCuentas(CuentasRequest request);

    Mono<VariableCuentasResponse> monetarias(CuentasMonetariasRequest request);

    Mono<VariableCuentasResponse> plazoFijo(CuentasPlazoFijoRequest request);

    Mono<VariableCuentasResponse> solicitudChequera(SolicitudChequeraRequest request);
}
