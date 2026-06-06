package com.pyg.ifm.modules.reclamos.controller;

import com.pyg.ifm.modules.reclamos.model.ReclamosRequest;
import com.pyg.ifm.modules.reclamos.model.ReclamosResponse;
import com.pyg.ifm.modules.reclamos.service.ReclamosService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reclamos")
@Hidden
public class ReclamosController {

    @Autowired
    private ReclamosService reclamosService;

    @PostMapping("/reclamos") //8765
    public Flux<ReclamosResponse> reclamos(@RequestBody ReclamosRequest request) {
        return reclamosService.reclamos(request);
    }
}
