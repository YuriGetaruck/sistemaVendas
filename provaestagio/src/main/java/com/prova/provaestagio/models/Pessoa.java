package com.prova.provaestagio.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

//@Getter
//@Setter
//@MappedSuperclass
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@EqualsAndHashCode(of = "cpf")
//@Table(name = "PESSOA")
public class Pessoa {

//    @Valid
//    @NotBlank
//    @Column(name = "CPF")
    private String cpf;


//    @Valid
//    @NotBlank
//    @Column(name = "NOME")
    private String nome;
}
