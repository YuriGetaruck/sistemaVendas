package com.prova.provaestagio.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "VENDEDOR")
public class Vendedor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotBlank
    @Column(name = "NOME_VENDEDOR")
    private String nome;

    @Valid
    @NotBlank
    @Column(name = "CPF_VENDEDOR")
    private String CPF;

}
