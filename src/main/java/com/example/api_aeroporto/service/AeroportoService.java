package com.example.api_aeroporto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_aeroporto.repository.AeroportoRepository;
import com.example.api_aeroporto.model.Aeroporto;

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

    public Optional<Aeroporto> buscarAeroportoPorCodigo_iata (String codigo_iata){
        return aeroportoRepository.findByCodigo_iata(codigo_iata);
    }

    public Aeroporto salvarAeroporto (Aeroporto aeroporto){
        return aeroportoRepository.save(aeroporto);
    }


    public Aeroporto atualizarAeroporto (Long id, Aeroporto aeroportoAtualizado ) {

        Aeroporto aeroportoExistente = aeroportoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException (
                String.format("Aeroporto com id %d não encontrado", id)));

        aeroportoExistente.setNomeAeroporto(aeroportoAtualizado.getNomeAeroporto());
        aeroportoExistente.setCodigo_pais_iso(aeroportoAtualizado.getCodigo_pais_iso());
        aeroportoExistente.setCodigo_iata(aeroportoAtualizado.getCodigo_iata());
        aeroportoExistente.setLatitude(aeroportoAtualizado.getLatitude());
        aeroportoExistente.setLongitude(aeroportoAtualizado.getLongitude());
        aeroportoExistente.setAltitude(aeroportoAtualizado.getAltitude());

        return aeroportoRepository.save(aeroportoExistente);
    }

    public void excluirAeroporto(Long id) {
        aeroportoRepository.deleteById(id);
    }
    
}