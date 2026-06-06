package com.pyg.ifm.modules.novedades.controller;

import com.pyg.ifm.modules.novedades.model.NovedadesRequest;
import com.pyg.ifm.modules.novedades.model.NovedadesResponse;
import com.pyg.ifm.modules.novedades.service.NovedadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/novedades")
public class NovedadesController {

    @Autowired
    private NovedadesService novedadesService;

    @PostMapping("/novedades") //318 Variables novedades
    public Mono<NovedadesResponse> novedades(@RequestBody NovedadesRequest request) {
        return novedadesService.novedades(request);
    }

}
