package com.pyg.ifm.modules.empleados.controller;

import com.pyg.ifm.modules.empleados.model.EmpleadosRequest;
import com.pyg.ifm.modules.empleados.model.EmpleadosResponse;
import com.pyg.ifm.modules.empleados.service.EmpleadosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private EmpleadosService service;

    @PostMapping("/empleados") //565
    @Operation(summary = "reportar acciones en maestro de empleaados", description = "Retorna status en monitor")
    public Mono<EmpleadosResponse> empleados(@RequestBody EmpleadosRequest request) {
        return service.empleados(request);
    }
}
