package com.prova.provaestagio.helper;

import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;

public class Helper {

    public static Venda umaVendaParaTeste(){
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(1L).build())
                .build();
    }

    public static Venda umaVendaParaTesteComVendedorInvalido(){
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(1000L).build())
                .build();
    }



}
