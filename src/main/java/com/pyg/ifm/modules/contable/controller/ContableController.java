package com.pyg.ifm.modules.contable.controller;

import com.pyg.ifm.modules.contable.model.*;
import com.pyg.ifm.modules.contable.service.ContableService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/contable")
@Hidden
public class ContableController {

    @Autowired
    private ContableService contableService;

    @PostMapping("/consultaMaestro") //640
    public Mono<MaestroContableResponse> consultaMaestro(@RequestBody MaestroContableRequest request) {
        return contableService.consultaMaestro(request);
    }

    @PostMapping("/consultaCuentas") //620
    public Flux<CuentaContableResponse> consultarCuentasContables(@RequestBody ConsultaCuentasContablesRequest request) {
        return contableService.consultarCuentasContables(request);
    }

    @PostMapping("/consultaMovimientos") //650
    public Flux<CuentaContableResponse> consultaMovimientosContables(@RequestBody MovimientosContablesRequest request) {
        return contableService.consultaMovimientosContables(request);
    }
}
