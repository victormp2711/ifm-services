package com.pyg.ifm.modules.internetbanking.controller;

import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingRequest;
import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingResponse;
import com.pyg.ifm.modules.internetbanking.service.InternetBankingService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/internet-banking")
@Hidden
public class InternetBankingController {

    @Autowired
    private InternetBankingService internetBankingService;

    @PostMapping("/solicitud") // 921
    public Mono<SolicitudInternetBankingResponse> solicitudAcceso(@RequestBody SolicitudInternetBankingRequest request) {
        return internetBankingService.solicitudAcceso(request);
    }
}
