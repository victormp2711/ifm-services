package com.pyg.ifm.modules.proveedores.controller;

import com.pyg.ifm.modules.proveedores.model.PagoProveedorResponse;
import com.pyg.ifm.modules.proveedores.model.PagoProveedoresRequest;
import com.pyg.ifm.modules.proveedores.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @PostMapping("/pagoProveedores") //582 Pagos a Proveedores
    public Mono<PagoProveedorResponse> pagoProveedores(@RequestBody PagoProveedoresRequest request) {
        return proveedoresService.pagoProveedores(request);
    }

}
