package com.example.api_aeroporto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.api_aeroporto.service.ConverterPaisesIsoService;

public class ConverteNomePaisParaIso {

    @Test
    public void deveConverterNomePaisParaIsoCorretamente() {

        String nomePais = "Brazil";
        String isoEsperado = "BR";

        String isoResultado = ConverterPaisesIsoService.obterIsoPais(nomePais);

        assertEquals(isoEsperado, isoResultado);

    }

}