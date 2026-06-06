package com.pyg.ifm.modules.proveedores.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.proveedores.model.PagoProveedorResponse;
import com.pyg.ifm.modules.proveedores.model.PagoProveedoresRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProveedoresServiceImpl implements ProveedoresService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<PagoProveedorResponse> pagoProveedores(PagoProveedoresRequest request) {
        return externalApiClient.post(
                "/proveedores/pagos",
                request,
                PagoProveedorResponse.class,
                "proveedores-pago"
        );
    }
}
