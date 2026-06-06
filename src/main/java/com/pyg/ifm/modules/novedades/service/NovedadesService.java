package com.pyg.ifm.modules.novedades.service;

import com.pyg.ifm.modules.novedades.model.NovedadesRequest;
import com.pyg.ifm.modules.novedades.model.NovedadesResponse;
import com.pyg.ifm.modules.novedades.model.ReintegroDeGastosRequest;
import reactor.core.publisher.Mono;

public interface NovedadesService {
    Mono<NovedadesResponse> novedades(NovedadesRequest request);
}
