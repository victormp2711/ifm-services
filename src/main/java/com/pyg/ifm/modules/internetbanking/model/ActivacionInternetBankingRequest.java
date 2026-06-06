package com.pyg.ifm.modules.internetbanking.model;

import lombok.Data;

@Data
public class ActivacionInternetBankingRequest {
    private String idSolicitud;
    private String tokenAcceso;
    private String nuevaContrasena;
}
