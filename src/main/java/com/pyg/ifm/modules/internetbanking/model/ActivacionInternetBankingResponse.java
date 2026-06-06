package com.pyg.ifm.modules.internetbanking.model;

import lombok.Data;

@Data
public class ActivacionInternetBankingResponse {
    private String idSolicitud;
    private String estado;
    private String fechaActivacion;
    private String mensaje;
}
