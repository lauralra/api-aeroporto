package com.example.api_aeroporto.controller;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.api_aeroporto.model.Aeroporto;
import com.example.api_aeroporto.repository.AeroportoRepository;

import jakarta.transaction.Transactional;


@Transactional
public class AeroportoControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private String urlBase() { return "http://localhost:" + port + "/api/v1/aeroportos"; }

    @Test
    public void deveCriarNovoAeroportoComSucesso() throws Exception {

    Aeroporto novoAeroporto = new Aeroporto();

        novoAeroporto.setNomeAeroporto("Santos");
        novoAeroporto.setCodigo_pais_iso("BR");
        novoAeroporto.setCodigo_iata("SDSSD");
        novoAeroporto.setLatitude(-123);
        novoAeroporto.setLongitude(234);
        novoAeroporto.setAltitude(678);

        ResponseEntity<Aeroporto> response = restTemplate.postForEntity(
            urlBase(), 
            novoAeroporto, 
            Aeroporto.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode(), "O status HTTP deve ser 201 Created.");

        Optional<Aeroporto> aeroportoDb = aeroportoRepository.findByCodigo_iata("SDD");

        assertTrue(aeroportoDb.isPresent(), 
            "O aeroporto deve ter sido salvo no banco de dados.");
    
    }

}