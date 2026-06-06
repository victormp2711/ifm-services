package com.pyg.ifm.modules.contable.service;

import com.pyg.ifm.modules.contable.model.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ContableService {
    Mono<MaestroContableResponse> consultaMaestro(MaestroContableRequest request);

    Flux<CuentaContableResponse> consultarCuentasContables(ConsultaCuentasContablesRequest request);

    Flux<CuentaContableResponse> consultaMovimientosContables(MovimientosContablesRequest request);
}
