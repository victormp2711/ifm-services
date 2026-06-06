package com.pyg.ifm.modules.internetbanking.service;

import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingRequest;
import com.pyg.ifm.modules.internetbanking.model.SolicitudInternetBankingResponse;
import reactor.core.publisher.Mono;

public interface InternetBankingService {
    Mono<SolicitudInternetBankingResponse> solicitudAcceso(SolicitudInternetBankingRequest request);
}
