package com.pyg.ifm.modules.creditos.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.creditos.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditosServiceImpl implements CreditosService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<SolicitudCreditoResponse> solicitarCredito(SolicitudCreditoRequest request) {
        return externalApiClient.post(
                "/creditos/solicitud",
                request,
                SolicitudCreditoResponse.class,
                "creditos-solicitud"
        );
    }

    @Override
    public Flux<SolicitudCreditoResponse> consultasBuro(ConsultasBuroRequest request) {
        return externalApiClient.postFlux(
                "/creditos/buro",
                request,
                SolicitudCreditoResponse.class,
                "creditos-buro"
        );
    }
}
