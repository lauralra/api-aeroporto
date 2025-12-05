package com.example.api_aeroporto.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.api_aeroporto.dto.mapper.AeroportoMapper;
import com.example.api_aeroporto.dto.request.AeroportoRequest;
import com.example.api_aeroporto.dto.response.AeroportoResponse;
import com.example.api_aeroporto.service.AeroportoService;
import com.example.api_aeroporto.model.Aeroporto;
import com.example.api_aeroporto.repository.AeroportoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/aeroportos")
public class AeroportoController {

    private AeroportoService aeroportoService;

    private AeroportoMapper aeroportoMapper;

    AeroportoRepository aeroportoRepository;

    @GetMapping
    public ResponseEntity<List<AeroportoResponse>> listarAeroportos() {

        List<AeroportoResponse> aeroportos = aeroportoService.getAllAeroportos()
        .stream()
        .map(aeroportoMapper::fromEntity)
        .collect(Collectors.toList());

        return ResponseEntity.ok(aeroportos);
    }

    @GetMapping ("/{iata}")
    public ResponseEntity<AeroportoResponse> buscarAeroportoPorCodigo_iata( @PathVariable String iata ) {
        
        Optional<Aeroporto> aeroportoOptional = aeroportoService.buscarAeroportoPorCodigo_iata( iata );

        if (aeroportoOptional.isPresent()) {

            AeroportoResponse response = aeroportoMapper.fromEntity( aeroportoOptional.get() );
            return ResponseEntity.ok(response);

        } 
    
    else return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<AeroportoResponse> CadastrarAeroporto ( @Valid @RequestBody AeroportoRequest aeroportoRequest ) {
        
        Aeroporto novoAeroporto = aeroportoService.salvarAeroporto(aeroportoMapper.toEntity(aeroportoRequest));

        AeroportoResponse response = aeroportoMapper.fromEntity(novoAeroporto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PutMapping ("/{iata}")
    public ResponseEntity<AeroportoResponse> atualizarAeroporto (@Valid @RequestBody AeroportoRequest aeroportoRequest, @PathVariable String iata) {

        Optional<Aeroporto> aeroportoOptional = aeroportoService.buscarAeroportoPorCodigo_iata( iata );

        if ( aeroportoOptional.isPresent()) {
            Aeroporto aeroportoAtualizado = aeroportoService.atualizarAeroporto( iata, aeroportoMapper.toEntity( aeroportoRequest ) );
            
            AeroportoResponse response = aeroportoMapper.fromEntity(aeroportoAtualizado);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping ("/{iata}")
    public void deletarAeroporto (@PathVariable String iata){

        aeroportoService.excluirAeroporto(iata);

        aeroportoRepository.deleteByCodigo_iata(iata);
        
    }


}