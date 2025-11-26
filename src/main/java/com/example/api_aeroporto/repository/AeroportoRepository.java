package com.example.api_aeroporto;

import java.util.Optional;

public interface AeroportoRepository {

    Optional<Aeroporto> findById(Integer idAeroporto);

}