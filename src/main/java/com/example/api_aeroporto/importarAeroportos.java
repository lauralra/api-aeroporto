package com.example.api_aeroporto;


import java.io.File;
import java.util.Scanner;

import com.example.api_aeroporto.Aeroporto;



public void importarAeroportos() {
    
    File file = new File("src/main/resources/templates/airports.csv");


    try (Scanner scan = new Scanner(file)) {
        
        scan.useDelimiter(";|\n"); 
        
        // Loop principal para ler cada registro
        while (scan.hasNextLine()) {

            String linha = scan.nextLine();
            
            String[] campos = linha.split(";"); 

            // Se a linha tem o número esperado de campos (ex: 14 campos)
            if (campos.length >= 14) { 
                Aeroporto aeroporto = new Aeroporto();
                
                aeroporto.setIdAeroporto(Integer.parseInt(campos[0].trim())); 
                
                // Mapeamento dos campos necessários (conforme a ordem do CSV)
                aeroporto.setNomeAeroporto(campos[1].trim()); 
                aeroporto.setLatitude(Double.parseDouble(campos[6].trim()));
                aeroporto.setLongitude(Double.parseDouble(campos[7].trim()));
                aeroporto.setAltitude(Double.parseDouble(campos[8].trim()));
                aeroporto.setCodigoPaisIso(campos[13].trim()); // O último campo (14º, índice 13)

                // Persistir o objeto no banco de dados
                // ESTA PARTE REQUER UM FRAMEWORK JDBC/JPA para funcionar
                // aeroportoRepository.save(aeroporto); 
            }
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}