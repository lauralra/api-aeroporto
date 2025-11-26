package com.example.api_aeroporto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Aeroporto {
    
    private int idAeroporto; 
    private String nomeAeroporto;
    private String codigoPaisIso;
    private double latitude;
    private double longitude;
    private double altitude;


}


