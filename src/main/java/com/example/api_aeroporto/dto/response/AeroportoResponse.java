package com.example.api_aeroporto.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;


@Getter
@Setter
@AllArgsConstructor

public class AeroportoResponse {

    private String nomeAeroporto;
    private String codigoPaisIso;
    private String codigo_iata;
    private double latitude;
    private double longitude;
    private double altitude;
    
}