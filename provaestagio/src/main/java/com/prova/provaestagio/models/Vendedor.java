package com.prova.provaestagio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@Entity
//@Getter
//@Setter
//@SuperBuilder()
//@EqualsAndHashCode(of = "id", callSuper = false)
//@Table(name = "VENDEDOR")

public class Vendedor extends Pessoa{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
    private Long id;

}
