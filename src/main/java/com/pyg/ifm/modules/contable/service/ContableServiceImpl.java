package com.pyg.ifm.modules.contable.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.contable.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ContableServiceImpl implements ContableService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<MaestroContableResponse> consultaMaestro(MaestroContableRequest request) {
        return externalApiClient.post(
                "/contable/maestros",
                request,
                MaestroContableResponse.class,
                "contable-maestro"
        );
    }

    @Override
    public Flux<CuentaContableResponse> consultarCuentasContables(ConsultaCuentasContablesRequest request) {
        return externalApiClient.postFlux(
                "/contable/cuentas",
                request,
                CuentaContableResponse.class,
                "contable-cuentas"
        );
    }

    @Override
    public Flux<CuentaContableResponse> consultaMovimientosContables(MovimientosContablesRequest request) {
        return externalApiClient.postFlux(
                "/contable/consultaMovimientos",
                request,
                CuentaContableResponse.class,
                "contable-movimientos"
        );
    }
}
