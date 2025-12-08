package com.example.api_aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_aeroporto.exception.AeroportoNaoEncontradoException;
import com.example.api_aeroporto.model.Aeroporto;
import com.example.api_aeroporto.repository.AeroportoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AeroportoService {

    @Autowired
    private AeroportoRepository aeroportoRepository;

    public List<Aeroporto> getAllAeroportos() {
        return (List<Aeroporto>) aeroportoRepository.findAll();
    }

    public Aeroporto getAeroportoById(int idAeroporto) {
        return aeroportoRepository.findById(idAeroporto).orElse(null);
    }

    public Aeroporto buscarAeroportoPorCodigo_iata (String codigo_iata){

        Optional<Aeroporto> aeroportoOptional = aeroportoRepository.findByCodigo_iata(codigo_iata);

        return aeroportoOptional
        .orElseThrow(() -> new AeroportoNaoEncontradoException (
            String.format("Aeroporto com código iata %s não encontrado", codigo_iata)));
        
    }

    public Optional<Aeroporto> buscarAeroportoPorId (int idAeroporto){
        return aeroportoRepository.findById( idAeroporto );
    }

    public Aeroporto salvarAeroporto (Aeroporto aeroporto){
            return aeroportoRepository.save(aeroporto);
    }


    public Aeroporto atualizarAeroporto (String codigo_iata, Aeroporto aeroportoAtualizado ) {

        Aeroporto aeroportoExistente = aeroportoRepository.findByCodigo_iata( codigo_iata )
                .orElseThrow(() -> new IllegalArgumentException (
                String.format("Aeroporto com codigo iata %d não encontrado", codigo_iata)));

        aeroportoExistente.setNomeAeroporto(aeroportoAtualizado.getNomeAeroporto());
        aeroportoExistente.setCodigo_pais_iso(aeroportoAtualizado.getCodigo_pais_iso());
        aeroportoExistente.setCodigo_iata(aeroportoAtualizado.getCodigo_iata());
        aeroportoExistente.setLatitude(aeroportoAtualizado.getLatitude());
        aeroportoExistente.setLongitude(aeroportoAtualizado.getLongitude());
        aeroportoExistente.setAltitude(aeroportoAtualizado.getAltitude());

        return aeroportoRepository.save(aeroportoExistente);
    }

    @Transactional
    public void excluirAeroporto(String codigo_iata) {
        aeroportoRepository.deleteByCodigo_iata(codigo_iata);
    }
    
}