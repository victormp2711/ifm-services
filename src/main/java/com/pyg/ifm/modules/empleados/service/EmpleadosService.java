package com.pyg.ifm.modules.empleados.service;


import com.pyg.ifm.modules.empleados.model.EmpleadosRequest;
import com.pyg.ifm.modules.empleados.model.EmpleadosResponse;
import reactor.core.publisher.Mono;

public interface EmpleadosService {
    Mono<EmpleadosResponse> empleados(EmpleadosRequest request);
}
