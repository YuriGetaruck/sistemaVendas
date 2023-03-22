package com.prova.provaestagio.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATA_VENDA")
    private OffsetDateTime dataVenda;

    @NotNull
    @Column(name = "VALOR")
    private Double valor;

    @NotNull
    @Column(name = "VENDEDOR_ID")
    private Long vendedorId;

    @NotBlank
    @Column(name = "VENDEDOR_NOME")
    private String vendedorNome;

}
