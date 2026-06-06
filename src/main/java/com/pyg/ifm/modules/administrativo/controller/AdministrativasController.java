package com.pyg.ifm.modules.administrativo.controller;

import com.pyg.ifm.modules.administrativo.model.NovedadesTarjetasRequest;
import com.pyg.ifm.modules.administrativo.model.TransaccionAdministrativaResponse;
import com.pyg.ifm.modules.administrativo.service.AdministrativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/administrativo")  //8630
public class AdministrativasController {

    @Autowired
    private AdministrativoService administrativoService;

    @PostMapping
    public Mono<TransaccionAdministrativaResponse> novedadesTarjetas(@RequestBody NovedadesTarjetasRequest request) {
        return administrativoService.novedadesTarjetas(request);
    }
}
