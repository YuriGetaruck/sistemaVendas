package com.prova.provaestagio.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.prova.provaestagio.enums.EStatusVenda;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;

import java.io.IOException;
import java.time.OffsetDateTime;

public class Helper {

    public static Venda umaVendaComVendedorInvalido(){
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(1000000L).build())
                .build();
    }

    public static Venda umaVendaParaTeste(){
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(1L).build())
                .build();
    }

    public static Venda umaVendaParaVendaResponseTeste(){
        return Venda.builder()
                .id(9999L)
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(1L).build())
                .vendaDate(OffsetDateTime.now())
                .statusVenda(EStatusVenda.ABERTA)
                .build();
    }

    public static Venda umaVendaParaTesteComVendedorInvalido(){
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(9999L).build())
                .build();
    }

    public static Vendedor umVendedorParaTeste(){
        return Vendedor.builder()
                .nome("Vendedor Gerado Por Teste")
                .CPF("999.999.999-99")
                .build();
    }

    public static Vendedor umVendedorParaControllerTest(){
        return Vendedor.builder()
                .nome("Vendedor Gerado Por Teste")
                .CPF("999.999.999-11")
                .build();
    }

    public static Vendedor umVendedorParaVendedorResponseTeste(){
        return Vendedor.builder()
                .id(9999L)
                .nome("Vendedor Gerado Por Teste Para VendedroResponseTest")
                .CPF("999.999.999-99")
                .build();
    }

    public static Vendedor umVendedorParaVendaControllerTest(){
        return Vendedor.builder()
                .id(1L)
                .nome("Vendedor Gerado Por Teste Para VendaControllerTest")
                .CPF("999.999.999-99")
                .build();
    }

    public static Venda umaVendaParaControllerTest(){
        var vendedor = umVendedorParaVendaControllerTest();
        return Venda.builder()
                .valor(99999.99)
                .vendedor(Vendedor.builder().id(vendedor.getId()).build())
                .build();
    }

    public static byte[] converteParaJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsBytes(object);
    }



}
