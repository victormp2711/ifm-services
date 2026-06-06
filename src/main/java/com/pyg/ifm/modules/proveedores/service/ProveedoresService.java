package com.pyg.ifm.modules.proveedores.service;

import com.pyg.ifm.modules.proveedores.model.PagoProveedorResponse;
import com.pyg.ifm.modules.proveedores.model.PagoProveedoresRequest;
import reactor.core.publisher.Mono;

public interface ProveedoresService {
    Mono<PagoProveedorResponse> pagoProveedores(PagoProveedoresRequest request);
}
