package com.pyg.ifm.modules.operaciones.deb.cre.controller;

import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercio;
import com.pyg.ifm.modules.operaciones.deb.cre.model.OperacionesDebCredComercioResponse;
import com.pyg.ifm.modules.operaciones.deb.cre.service.OperacionesDebCredImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/operaciones")
@Slf4j
public class OperacionesDebCredController {

    @Autowired
    private OperacionesDebCredImpl operacionesDebCred;

    @PostMapping("/debitocreditoTarjeta") //8620
    public Mono<OperacionesDebCredComercioResponse> operacionesDebCred(@RequestBody OperacionesDebCredComercio request) {
        return operacionesDebCred.operacionesDebCred(request);
    }

    @PostMapping("/debitocreditoComercio") //8625
    public Mono<OperacionesDebCredComercioResponse> operacionesDebCredComercio(@RequestBody OperacionesDebCredComercio request) {
        log.info("variable : " + request);
        return operacionesDebCred.operacionesDebCredComercio(request);
    }
}
