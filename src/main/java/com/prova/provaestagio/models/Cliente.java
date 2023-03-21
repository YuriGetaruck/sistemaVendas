package com.prova.provaestagio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

//@Data
//@Entity
//@SuperBuilder
//@EqualsAndHashCode(of = "id", callSuper = false)
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "CLIENTE")
public class Cliente extends Pessoa{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
    private Long id;
}
