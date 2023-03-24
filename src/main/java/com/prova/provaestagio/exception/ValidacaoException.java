package com.prova.provaestagio.exception;

import com.prova.provaestagio.dtos.VendedorResumoResponse;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String menssagem){
        super(menssagem);
    }

}
