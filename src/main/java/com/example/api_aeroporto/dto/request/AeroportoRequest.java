package com.example.api_aeroporto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size (min = 2, max = 2, message = "O código do país deve conter 2 caracteres")
    private String codigo_pais_iso;

    @NotBlank (message = "O codigo iata é obrigatório")
    @Size (min = 3, max = 3, message = "O código iata deve conter 3 caracteres")
    private String codigo_iata;

    @NotNull (message = "A latitude é obrigatória")
    private double latitude;

    @NotNull (message = "A longitude é obrigatória")
    private double longitude;

    @NotNull (message = "A altitude é obrigatória")
    private double altitude;

}