package com.example.api_aeroporto.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.api_aeroporto.model.Aeroporto;

public interface AeroportoRepository extends CrudRepository<Aeroporto, int> {

    Optional<Aeroporto> findByCodigo_iata(String codigo_iata);

    void deleteByCodigo_iata(String codigo_iata);


}