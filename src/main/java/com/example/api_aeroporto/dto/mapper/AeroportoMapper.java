package com.example.api_aeroporto.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.api_aeroporto.dto.request.AeroportoRequest;
import com.example.api_aeroporto.dto.response.AeroportoResponse;
import com.example.api_aeroporto.model.Aeroporto;


@Component
public class AeroportoMapper {

    public static Aeroporto toEntity ( AeroportoRequest request) {

        if (request == null) {
            return null;
        }

        Aeroporto aeroporto = new Aeroporto();
        
        aeroporto.setNomeAeroporto(request.getNomeAeroporto());
        aeroporto.setCodigo_pais_iso(request.getCodigo_pais_iso());
        aeroporto.setCodigo_iata(request.getCodigo_iata());
        aeroporto.setLatitude(request.getLatitude());
        aeroporto.setLongitude(request.getLongitude());
        aeroporto.setAltitude(request.getAltitude());

        return aeroporto;
    }
    
    public AeroportoResponse fromEntity ( Aeroporto aeroporto) {

        if (aeroporto == null) {
            return null;
        }

        AeroportoResponse response = new AeroportoResponse();
        
        response.setNomeAeroporto(aeroporto.getNomeAeroporto());
        response.setCodigo_pais_iso(aeroporto.getCodigo_pais_iso());
        response.setCodigo_iata(aeroporto.getCodigo_iata());
        response.setLatitude(aeroporto.getLatitude());
        response.setLongitude(aeroporto.getLongitude());
        response.setAltitude(aeroporto.getAltitude());

        return response;
    }

}