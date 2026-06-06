package com.pyg.ifm.modules.novedades.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.novedades.model.NovedadesRequest;
import com.pyg.ifm.modules.novedades.model.NovedadesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NovedadesServiceImpl implements NovedadesService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<NovedadesResponse> novedades(NovedadesRequest request) {
        return externalApiClient.post(
                "/novedades",
                request,
                NovedadesResponse.class,
                "novedades"
        );
    }
}
