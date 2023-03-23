package com.prova.provaestagio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prova.provaestagio.model.enums.StatusVenda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "VENDA")
public class Venda {

    //Uma venda é composta por id, data da venda, valor, vendedor id e vendedor nome.

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusVenda statusVenda;

    @Column(name = "DATA_VENDA")
    private OffsetDateTime vendaDate;

    @Column(name = "VALOR")
    @NotNull
    private Double valor;

    @ManyToOne
    @JsonIgnoreProperties("vendas")
    private Vendedor vendedor;

}
