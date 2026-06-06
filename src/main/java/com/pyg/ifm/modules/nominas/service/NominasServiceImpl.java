package com.pyg.ifm.modules.nominas.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.nominas.model.NominaRequest;
import com.pyg.ifm.modules.nominas.model.NominaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NominasServiceImpl implements NominasService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<NominaResponse> nominas(NominaRequest request) {
        return externalApiClient.post(
                "/nominas/nominas",
                request,
                NominaResponse.class,
                "nominas"
        );
    }
}
