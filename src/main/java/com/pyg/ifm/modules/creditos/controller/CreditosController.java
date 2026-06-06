package com.pyg.ifm.modules.creditos.controller;

import com.pyg.ifm.modules.creditos.model.*;
import com.pyg.ifm.modules.creditos.service.CreditosService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/creditos")
@Hidden
public class CreditosController {

    @Autowired
    private CreditosService creditosService;

    @PostMapping("/solicitud") //(915)
    public Mono<SolicitudCreditoResponse> solicitarCredito(@RequestBody SolicitudCreditoRequest request) {
        return creditosService.solicitarCredito(request);
    }

    @GetMapping("/consultasBuro") //917
    public Flux<SolicitudCreditoResponse> consultasBuro(@RequestBody ConsultasBuroRequest request) {
        return creditosService.consultasBuro(request);
    }
}
