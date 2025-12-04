package com.example.api_aeroporto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class AeroportoRequest {

    @NotBlank (message = "O nome do aeroporto é obrigatório")
    private String nomeAeroporto;

    @NotBlank (message = "O código do país é obrigatório")
    private String codigoPaisIso;

    @NotBlank (message = "O codigo iata é obrigatório")
    private String codigo_iata;

    @NotNull (message = "A latitude é obrigatória")
    private double latitude;

    @NotNull (message = "A longitude é obrigatória")
    private double longitude;

    @NotNull (message = "A altitude é obrigatória")
    private double altitude;

}