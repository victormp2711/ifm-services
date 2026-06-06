package com.pyg.ifm.modules.reclamos.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.reclamos.model.ReclamosRequest;
import com.pyg.ifm.modules.reclamos.model.ReclamosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class ReclamosServiceImpl implements ReclamosService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Flux<ReclamosResponse> reclamos(ReclamosRequest request) {
        return externalApiClient.postFlux(
                "/reclamos/reclamos",
                request,
                ReclamosResponse.class,
                "reclamos"
        );
    }
}
