package com.pyg.ifm.modules.reclamos.service;

import com.pyg.ifm.modules.reclamos.model.ReclamosRequest;
import com.pyg.ifm.modules.reclamos.model.ReclamosResponse;
import reactor.core.publisher.Flux;

public interface ReclamosService {
    Flux<ReclamosResponse> reclamos(ReclamosRequest request);
}

