package com.pyg.ifm.modules.empleados.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.empleados.model.EmpleadosRequest;
import com.pyg.ifm.modules.empleados.model.EmpleadosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<EmpleadosResponse> empleados(EmpleadosRequest request) {
        return externalApiClient.post(
                "/empleados/empleados",
                request,
                EmpleadosResponse.class,
                "empleados"
        );
    }
}
