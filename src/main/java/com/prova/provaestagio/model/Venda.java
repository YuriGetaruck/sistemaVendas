package com.prova.provaestagio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prova.provaestagio.enums.EStatusVenda;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "VENDA")
@Builder
@AllArgsConstructor
public class Venda {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EStatusVenda statusVenda;

    @Column(name = "DATA_VENDA")
    private OffsetDateTime vendaDate;

    @Column(name = "VALOR")
    @NotNull
    private Double valor;

    @ManyToOne
    @JsonIgnoreProperties("vendas")
    private Vendedor vendedor;

}
