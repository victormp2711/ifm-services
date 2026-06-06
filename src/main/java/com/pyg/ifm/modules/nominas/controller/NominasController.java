package com.pyg.ifm.modules.nominas.controller;

import com.pyg.ifm.modules.nominas.model.NominaRequest;
import com.pyg.ifm.modules.nominas.model.NominaResponse;
import com.pyg.ifm.modules.nominas.service.NominasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nominas")
@Slf4j
public class NominasController {

    @Autowired
    private NominasService nominasService;

    @PostMapping("/nomina") //567 Nominas
    public Mono<NominaResponse> nominas(@RequestBody NominaRequest request) {
        log.info("request : " + request);
        return nominasService.nominas(request);
    }
}
