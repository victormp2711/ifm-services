package com.pyg.ifm.modules.creditos.service;

import com.pyg.ifm.modules.creditos.model.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditosService {
    Mono<SolicitudCreditoResponse> solicitarCredito(SolicitudCreditoRequest request);

    Flux<SolicitudCreditoResponse> consultasBuro(ConsultasBuroRequest request);
}
