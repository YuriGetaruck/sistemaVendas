package com.prova.provaestagio.dtos;

import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.model.Venda;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VendedorResponse {

    private String nome;

    private double totalDeVendasNoPeriodo;

    private double mediaDeVendasDiariasNoPeriodo;

    public VendedorResponse(List<Venda> vendasDoVendedor, Double tamanhoPeriodoDias){
        this.nome = vendasDoVendedor.get(0).getVendedor().getNome();
        this.totalDeVendasNoPeriodo = vendasDoVendedor.size();
        this.mediaDeVendasDiariasNoPeriodo = (vendasDoVendedor.size()/tamanhoPeriodoDias);
    }





}
