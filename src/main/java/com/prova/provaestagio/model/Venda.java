package com.prova.provaestagio.model;

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
@NoArgsConstructor
public class Venda {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "SEQ_VENDA", sequenceName = "SEQ_VENDA", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_VENDA", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private EStatusVenda statusVenda;

    @Column(name = "DATA_VENDA")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime vendaDate;

    @Column(name = "VALOR")
    @NotNull
    private Double valor;

    @ManyToOne
    private Vendedor vendedor;

}
