package com.pyg.ifm.modules.tarjetas.service;

import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaDebitoRequest;
import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaResponse;
import reactor.core.publisher.Mono;

public interface TarjetasService {
    Mono<SolicitudTarjetaResponse> solicitudTarjetaDebito(SolicitudTarjetaDebitoRequest request);

}
