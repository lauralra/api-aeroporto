package com.example.api_aeroporto.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "aeroporto")
@Entity

public class Aeroporto {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_aeroporto", nullable = false, unique = true)
    private int idAeroporto; 

    @Column (name = "nome_aeroporto", nullable = false)
    private String nomeAeroporto;

    @Column (name = "codigo_pais_iso", nullable = false, length = 2)
    private String codigoPaisIso;

    @Column (name = "latitude", nullable = false)
    private double latitude;

    @Column (name = "longitude", nullable = false)
    private double longitude;

    @Column (name = "altitude", nullable = false)
    private double altitude;


}


