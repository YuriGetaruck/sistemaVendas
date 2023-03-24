package com.prova.provaestagio.dtos;


import com.prova.provaestagio.model.Vendedor;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VendedorResponse {

    private Long id;
    private String nome;

    public static VendedorResponse of(Vendedor vendedor){
        return VendedorResponse.builder().
                id(vendedor.getId()).
                nome(vendedor.getNome()).
                build();
    }
}
