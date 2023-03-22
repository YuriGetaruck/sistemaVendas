package com.prova.provaestagio.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VendaModel {

    private Long id;

    private OffsetDateTime dataVenda;

    private Double valor;

    private Long vendedorId;

    private String vendedorNome;


}

