package com.pyg.ifm.modules.cuentas.controller;

import com.pyg.ifm.modules.cuentas.model.*;
import com.pyg.ifm.modules.cuentas.service.CuentasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cuentas")
@Slf4j
public class CuentasController {

    @Autowired
    private CuentasService cuentasService;

    @PostMapping("/apertura") // 310
    public Mono<AperturaCuentaResponse> apertura(@RequestBody AperturaCuentaRequest request) {
        return cuentasService.aperturaCuenta(request);
    }

    @PostMapping("/cuentas") // 345
    public Mono<VariableCuentasResponse> cuentas(@RequestBody CuentasRequest request) {
        log.info("variable : " + request);
        return cuentasService.variableCuentas(request);
    }

/*    @PostMapping("/monetarias")
    public Mono<VariableCuentasResponse> monetarias(@RequestBody CuentasMonetariasRequest request) {
        log.info("variable : " + request);
        return cuentasService.monetarias(request);
    }*/

    @PostMapping("/plazoFijo") // 347
    public Mono<VariableCuentasResponse> plazoFijo(@RequestBody CuentasPlazoFijoRequest request) {
        log.info("variable : " + request);
        return cuentasService.plazoFijo(request);
    }

    @PostMapping("/solicitudChequera") // 919
    public Mono<VariableCuentasResponse> solicitudChequera(@RequestBody SolicitudChequeraRequest request) {
        log.info("variable : " + request);
        return cuentasService.solicitudChequera(request);
    }

}
