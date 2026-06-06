package com.pyg.ifm.modules.internetbanking.service;

import com.pyg.ifm.client.ExternalApiClient;
import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingRequest;
import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class InternetBankingServiceImpl implements InternetBankingService {

    private final ExternalApiClient externalApiClient;

    @Override
    public Mono<SolicitudInternetBankingResponse> solicitudAcceso(SolicitudInternetBankingRequest request) {
        return externalApiClient.post(
                "/internet-banking/solicitudAcceso",
                request,
                SolicitudInternetBankingResponse.class,
                "internet-banking-solicitud"
        );
    }
}
