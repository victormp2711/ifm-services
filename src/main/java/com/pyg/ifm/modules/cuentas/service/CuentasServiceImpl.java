package com.pyg.ifm.modules.cuentas.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.cuentas.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class CuentasServiceImpl implements CuentasService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<AperturaCuentaResponse> aperturaCuenta(AperturaCuentaRequest request) {
        return externalApiClient.post(
                "/cuentas/apertura",
                request,
                AperturaCuentaResponse.class,
                "cuentas-apertura"
        );
    }

    @Override
    public Mono<VariableCuentasResponse> variableCuentas(CuentasRequest request) {
        log.info("variableCuentas : {}", request);
        return externalApiClient.post(
                "/cuentas/variables",
                request,
                VariableCuentasResponse.class,
                "cuentas-variables"
        );
    }

    @Override
    public Mono<VariableCuentasResponse> monetarias(CuentasMonetariasRequest request) {
        log.info("monetarias : {}", request);
        return externalApiClient.post(
                "/cuentas/monetarias",
                request,
                VariableCuentasResponse.class,
                "cuentas-monetarias"
        );
    }

    @Override
    public Mono<VariableCuentasResponse> plazoFijo(CuentasPlazoFijoRequest request) {
        log.info("plazoFijo : {}", request);
        return externalApiClient.post(
                "/cuentas/plazoFijo",
                request,
                VariableCuentasResponse.class,
                "cuentas-plazo-fijo"
        );
    }

    @Override
    public Mono<VariableCuentasResponse> solicitudChequera(SolicitudChequeraRequest request) {
        log.info("solicitudChequera : {}", request);
        return externalApiClient.post(
                "/cuentas/solicitudChequera",
                request,
                VariableCuentasResponse.class,
                "cuentas-solicitud-chequera"
        );
    }
}
