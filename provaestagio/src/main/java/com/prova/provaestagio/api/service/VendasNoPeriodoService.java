package com.prova.provaestagio.api.service;


import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.dtos.VendaResponse;
import com.prova.provaestagio.model.Venda;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VendasNoPeriodoService {


    VendaRepository vendaRepository;

    @Transactional
    public List<Venda> vedasNoPeriodo(String dataInicial, String dataFinal){

        if (ValidaDataService.validaData(dataInicial, dataFinal)){
            return vendaRepository.findByVendaDateBetween(
                    OffsetDateTime.parse(dataInicial + "T00:00:00.000000000-03:00"),
                    OffsetDateTime.parse(dataFinal   + "T23:59:59.990000000-03:00"));
        }else{
            Venda venda = new Venda();

            List<Venda> vendas = new ArrayList<>();

            vendas.add(venda);
            return vendas;
        }
    }


}
