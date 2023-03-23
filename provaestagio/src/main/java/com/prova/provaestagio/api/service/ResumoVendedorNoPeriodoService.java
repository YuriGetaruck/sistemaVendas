package com.prova.provaestagio.api.service;


import com.prova.provaestagio.api.repository.VendedorRepository;
import com.prova.provaestagio.dtos.VendedorResponse;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ResumoVendedorNoPeriodoService {

    VendasNoPeriodoService vendasNoPeriodoService;

    VendedorRepository vendedorRepository;


    @Transactional
    public List<VendedorResponse> resumoVendedor(@PathVariable String dataInicial, @PathVariable String dataFinal){

        long diasNoPerido = DiasEntreDatasService.diasNoPeriodo(dataInicial, dataFinal);
        List<Venda> vendasNoPerido = vendasNoPeriodoService.vedasNoPeriodo(dataInicial, dataFinal);
        List<Vendedor> vendedores = vendedorRepository.findAll().stream().toList();
        List<VendedorResponse> vendedorResponses = new ArrayList<>();

        for (Vendedor vendedor: vendedores) {
            List<Venda> vendasDoVendedor = new ArrayList<>();
            for (Venda venda: vendasNoPerido) {
                if(venda.getVendedor().getId().equals(vendedor.getId())){
                    vendasDoVendedor.add(venda);
                }
            }
            VendedorResponse vendedorResponse = new VendedorResponse(vendasDoVendedor, Double.valueOf(diasNoPerido));
            vendedorResponses.add(vendedorResponse);
        }

        return vendedorResponses;
    }
}
