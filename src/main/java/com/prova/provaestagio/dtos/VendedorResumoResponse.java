package com.prova.provaestagio.dtos;

import com.prova.provaestagio.model.Venda;
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

    public VendedorResumoResponse(List<Venda> vendasDoVendedor, Double tamanhoPeriodoDias){
        this.nome = vendasDoVendedor.get(0).getVendedor().getNome();
        this.totalDeVendasNoPeriodo = vendasDoVendedor.size();
        this.mediaDeVendasDiariasNoPeriodo = (vendasDoVendedor.size()/tamanhoPeriodoDias);
    }
}
