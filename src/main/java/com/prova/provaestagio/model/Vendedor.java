package com.prova.provaestagio.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;


@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "VENDEDOR",  uniqueConstraints = {@UniqueConstraint(columnNames = "CPF_VENDEDOR")})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor{

    @Id
    @SequenceGenerator(name = "SEQ_VENDEDOR", sequenceName = "SEQ_VENDEDOR", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_VENDEDOR", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Valid
    @NotBlank
    @Column(name = "CPF_VENDEDOR")
    private String CPF;

    @Valid
    @NotBlank
    @Column(name = "NOME_VENDEDOR")
    private String nome;

}
