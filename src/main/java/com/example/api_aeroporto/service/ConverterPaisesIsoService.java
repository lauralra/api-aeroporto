package com.example.api_aeroporto.service;

import java.util.Locale;

public class ConverterPaisesIsoService {

    public static String obterIsoPais(String nomePais) {

        // obtém codigo iso de paises
        String[] codigosPaises = Locale.getISOCountries();

        for (String codigo : codigosPaises) {

            Locale locale = new Locale("", codigo);
            
            String nomeExibicao = locale.getDisplayCountry(Locale.ENGLISH);

            if (nomeExibicao.equalsIgnoreCase(nomePais.trim())) {
                // Se o nome do país for igual (ignorando maiúsculas/minúsculas), retorna o código ISO.
                return codigo;
            }
        }

        // Retorna uma string vazia se o país não for encontrado.
        return "";
    }
}