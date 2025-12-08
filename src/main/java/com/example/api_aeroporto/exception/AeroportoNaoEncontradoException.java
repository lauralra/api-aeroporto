package com.example.api_aeroporto.exception;


public class AeroportoNaoEncontradoException extends RuntimeException { 
    
    public AeroportoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    
}