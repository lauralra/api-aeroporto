package com.example.api_aeroporto.service;


import java.io.File;
import java.util.Scanner;

import com.example.api_aeroporto.model.Aeroporto;


public class ImportarAeroportosService {
    
    public void importarAeroportos() {
    
    File file = new File("src/main/resources/templates/airports.csv");


    try (Scanner scan = new Scanner(file)) {
        
        scan.useDelimiter(";|\n"); 
        
        // Loop principal para ler cada registro
        while (scan.hasNextLine()) {

            String linha = scan.nextLine();
            
            String[] campos = linha.split(";"); 


            if (campos.length >= 12) { 
                Aeroporto aeroporto = new Aeroporto();
                
                aeroporto.setIdAeroporto(Integer.parseInt(campos[0].trim())); 
                
                
                aeroporto.setNomeAeroporto(campos[1].trim()); 
                aeroporto.setLatitude(Double.parseDouble(campos[6].trim()));
                aeroporto.setLongitude(Double.parseDouble(campos[7].trim()));
                aeroporto.setAltitude(Double.parseDouble(campos[8].trim()));
                aeroporto.setCodigoPaisIso(campos[13].trim());

                // AeroportoRepository.save(aeroporto); 
            }
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}