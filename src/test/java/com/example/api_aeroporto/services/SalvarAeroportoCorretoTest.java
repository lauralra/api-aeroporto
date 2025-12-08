package com.example.api_aeroporto.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.api_aeroporto.model.Aeroporto;
import com.example.api_aeroporto.repository.AeroportoRepository;
import com.example.api_aeroporto.service.AeroportoService;


public class SalvarAeroportoCorretoTest {

    @Autowired
    private AeroportoRepository aeroportoRepository; 

    @Autowired
    private AeroportoService aeroportoService; 

    @Test
    public void naoDeveSalvarAeroportoComInformacoesInvalidas() {
        
        Aeroporto aeroportoInvalido = new Aeroporto();
        
        aeroportoInvalido.setCodigo_iata("GRUU"); 
        aeroportoInvalido.setNomeAeroporto("Aeroporto Invalido");
        
    }

}