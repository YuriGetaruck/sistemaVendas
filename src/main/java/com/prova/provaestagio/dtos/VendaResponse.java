package com.prova.provaestagio.dtos;

import com.prova.provaestagio.enums.EStatusVenda;
import com.prova.provaestagio.model.Venda;
import lombok.*;

import java.time.OffsetDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VendaResponse {

    private Long id;
    private OffsetDateTime dataVenda;
    private Double valor;
    private EStatusVenda statusVenda;
    private VendedorResponse vendedorResponse;

    public static VendaResponse of(Venda venda) {
        return VendaResponse.builder()
                .id(venda.getId())
                .dataVenda(venda.getVendaDate())
                .valor(venda.getValor())
                .statusVenda(venda.getStatusVenda())
                .vendedorResponse(VendedorResponse.of(venda.getVendedor()))
                .build();
    }
}
