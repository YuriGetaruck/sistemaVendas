package com.prova.provaestagio.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Venda {


    //Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATA_VENDA")
    private OffsetDateTime dataVenda;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "VENDEDOR_ID")
    private Long vendedorId;

    @Column(name = "VENDEDOR_NOME")
    private String VendedorNome;

}
