package com.prova.provaestagio.exception;

public class NegocioException extends RuntimeException{

    private static long serialVersionUID = 1L;

    public NegocioException(String menssagem){
        super(menssagem);
    }
}
