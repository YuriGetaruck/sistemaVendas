package com.prova.provaestagio.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.xml.stream.events.StartElement;

//@Entity
//@Data
//@EqualsAndHashCode(of = "id")
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "PRODUTO")
public class Produto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
    private Long id;

//    @Valid
//    @NotBlank
//    @Size(min = 2, max = 60)
//    @Column(name = "NOME")
    private String nome;

//    @Valid
//    @NotNull
//    @Size(min = 0, max = 99999999)
//    @Column(name = "PRECO")
    private Double preco;


//    @Valid
//    @NotNull
//    @Size(min = 0, max = 1)
//    @Column(name = "DESCONTO")
    private Double deconto;

}
