package com.example.api_aeroporto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.api_aeroporto.service.ConversorService;

public class ConvertePesParaMetrosTest {
    
    @Test
    public void deveConverterPesParaMetrosCorretamente() {
        double pes = 1000.0;
        double metrosEsperados = 304.8;
        double delta = 0.1;

        double resultado = ConversorService.converterPesParaMetros(pes);

        assertEquals(metrosEsperados,resultado, delta);
    }
    

}
