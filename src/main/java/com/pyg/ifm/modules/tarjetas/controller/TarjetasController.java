package com.pyg.ifm.modules.tarjetas.controller;

import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaDebitoRequest;
import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaResponse;
import com.pyg.ifm.modules.tarjetas.service.TarjetasService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tarjetas")
@Hidden
public class TarjetasController {

    @Autowired
    private TarjetasService tarjetasService;

    @PostMapping("/solicitudTarjetaDebito") //920
    public Mono<SolicitudTarjetaResponse> solicitudTarjetaDebito(@RequestBody SolicitudTarjetaDebitoRequest request) {
        return tarjetasService.solicitudTarjetaDebito(request);
    }
}
