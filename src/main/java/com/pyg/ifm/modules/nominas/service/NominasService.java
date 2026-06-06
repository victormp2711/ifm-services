package com.pyg.ifm.modules.nominas.service;

import com.pyg.ifm.modules.nominas.model.NominaRequest;
import com.pyg.ifm.modules.nominas.model.NominaResponse;
import reactor.core.publisher.Mono;

public interface NominasService {
    Mono<NominaResponse> nominas(NominaRequest request);
}
