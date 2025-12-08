package com.example.api_aeroporto.service;

public class ConversorService {

    public static double converterPesParaMetros(double pes) {

        double metros = pes / 3.281;
        return metros;
    
    }
}