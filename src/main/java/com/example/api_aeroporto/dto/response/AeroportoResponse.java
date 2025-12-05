package com.example.api_aeroporto.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AeroportoResponse {

    private String nomeAeroporto;
    private String codigo_pais_iso;
    private String codigo_iata;
    private double latitude;
    private double longitude;
    private double altitude;
    
}