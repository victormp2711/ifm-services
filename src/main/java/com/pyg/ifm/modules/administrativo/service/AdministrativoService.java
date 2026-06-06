package com.pyg.ifm.modules.administrativo.service;

import com.pyg.ifm.modules.administrativo.model.NovedadesTarjetasRequest;
import com.pyg.ifm.modules.administrativo.model.TransaccionAdministrativaResponse;
import reactor.core.publisher.Mono;

public interface AdministrativoService {
    Mono<TransaccionAdministrativaResponse> novedadesTarjetas(NovedadesTarjetasRequest request);
}
