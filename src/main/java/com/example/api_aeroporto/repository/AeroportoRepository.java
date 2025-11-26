package com.example.api_aeroporto.repository;

import java.util.Optional;

import com.example.api_aeroporto.model.Aeroporto;

public interface AeroportoRepository {

    Optional<Aeroporto> findById(Integer idAeroporto);

}