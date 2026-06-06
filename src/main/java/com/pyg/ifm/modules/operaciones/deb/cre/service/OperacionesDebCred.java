package com.pyg.ifm.modules.operaciones.deb.cre.service;

import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercio;
import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercioResponse;
import reactor.core.publisher.Mono;

public interface OperacionesDebCred {
    Mono<OperacionesDebCredComercioResponse> operacionesDebCred(OperacionesDebCredComercio request);

    Mono<OperacionesDebCredComercioResponse> operacionesDebCredComercio(OperacionesDebCredComercio request);
}
