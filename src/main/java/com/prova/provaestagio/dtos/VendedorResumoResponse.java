package com.prova.provaestagio.dtos;

import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VendedorResumoResponse {

    private String nome;
    private double totalDeVendasNoPeriodo;
    private double mediaDeVendasDiariasNoPeriodo;

    //tentar tirar o get

    public VendedorResumoResponse(List<Venda> vendasDoVendedor, Double tamanhoPeriodoDias, Vendedor vendedor) {
        this.nome = vendedor.getNome();
        this.totalDeVendasNoPeriodo = vendasDoVendedor.size();
        this.mediaDeVendasDiariasNoPeriodo = (vendasDoVendedor.size() / tamanhoPeriodoDias);
    }
}
