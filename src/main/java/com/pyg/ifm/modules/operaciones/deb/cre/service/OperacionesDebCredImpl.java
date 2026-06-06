package com.pyg.ifm.modules.operaciones.deb.cre.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercio;
import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercioResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class OperacionesDebCredImpl implements OperacionesDebCred {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<OperacionesDebCredComercioResponse> operacionesDebCred(OperacionesDebCredComercio request) {
        return externalApiClient.post(
                "/operaciones/operacionesDebCred",
                request,
                OperacionesDebCredComercioResponse.class,
                "operaciones-deb-cred-tarjeta"
        );
    }

    @Override
    public Mono<OperacionesDebCredComercioResponse> operacionesDebCredComercio(OperacionesDebCredComercio request) {
        log.info("operacionesDebCredComercio : {}", request);
        return externalApiClient.post(
                "/operaciones/operacionesDebCredComercio",
                request,
                OperacionesDebCredComercioResponse.class,
                "operaciones-deb-cred-comercio"
        );
    }
}
