package com.pyg.ifm.modules.tarjetas.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaDebitoRequest;
import com.pyg.ifm.modules.tarjetas.model.SolicitudTarjetaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TarjetasServiceImpl implements TarjetasService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<SolicitudTarjetaResponse> solicitudTarjetaDebito(SolicitudTarjetaDebitoRequest request) {
        return externalApiClient.post(
                "/tarjetas/solicitudTarjetaDebito",
                request,
                SolicitudTarjetaResponse.class,
                "tarjetas-solicitud-debito"
        );
    }
}
