package com.prova.provaestagio.dtos;

import java.time.OffsetDateTime;

public class VendaResponse {

    private Long id;

    private OffsetDateTime dataVenda;

    private Double valor;

    private VendedorResponse vendedorResponse;
}
