package com.example.api_aeroporto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.api_aeroporto.dto.mapper.AeroportoMapper;
import com.example.api_aeroporto.dto.response.AeroportoResponse;
import com.example.api_aeroporto.service.AeroportoService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/aeroportos")
public class AeroportoController {

    private AeroportoService aeroportoService;

    private AeroportoMapper aeroportoMapper;

    @GetMapping
    public ResponseEntity<List<AeroportoResponse>> listarAeroportos() {

        List<AeroportoResponse> aeroportos = aeroportoService.getAllAeroportos()
        .stream()
        .map(aeroportoMapper::fromEntity)
        .collect(Collectors.toList());

        return ResponseEntity.ok(aeroportos);
    }



}