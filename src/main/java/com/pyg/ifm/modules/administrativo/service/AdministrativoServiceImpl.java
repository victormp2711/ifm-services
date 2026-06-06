package com.pyg.ifm.modules.administrativo.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.administrativo.model.NovedadesTarjetasRequest;
import com.pyg.ifm.modules.administrativo.model.TransaccionAdministrativaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AdministrativoServiceImpl implements AdministrativoService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<TransaccionAdministrativaResponse> novedadesTarjetas(NovedadesTarjetasRequest request) {
        return externalApiClient.post(
                "/administrativo/novedadesTarjetas",
                request,
                TransaccionAdministrativaResponse.class,
                "administrativo-novedades-tarjetas"
        );
    }
}
