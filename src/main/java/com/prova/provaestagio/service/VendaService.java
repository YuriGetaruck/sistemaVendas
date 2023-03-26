package com.prova.provaestagio.service;


import com.prova.provaestagio.comum.DataService;
import com.prova.provaestagio.dtos.VendaResponse;
import com.prova.provaestagio.exception.NegocioException;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;
import com.prova.provaestagio.repository.VendaRepository;
import com.prova.provaestagio.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

import static com.prova.provaestagio.enums.EStatusVenda.ABERTA;

@AllArgsConstructor
@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private DataService dataService;

    public List<VendaResponse> buscarTodasVendas(){
        return vendaRepository.findAll().stream().map(VendaResponse::of).toList();
    }

    @Transactional
    public List<Venda> vendasNoPeriodo(String dataInicial, String dataFinal){

        dataService.validaDataValida(dataInicial,dataFinal);

        return vendaRepository.findByVendaDateBetween(
                OffsetDateTime.parse(dataInicial + "T00:00:00.000000000-03:00"),
                OffsetDateTime.parse(dataFinal   + "T23:59:59.990000000-03:00"));

    }

    @Transactional
    private Venda definirVendaAberta(Vendedor vendedor, Venda venda){
        return Venda.builder()
                .vendaDate(OffsetDateTime.now())
                .vendedor(vendedor)
                .statusVenda(ABERTA)
                .valor(venda.getValor())
                .build();
    }

    @Transactional
    public Venda gerarVenda(Venda venda){
        var vendedor = vendedorRepository.findById(venda.getVendedor().getId())
                .orElseThrow(() -> new NegocioException("Vendedor nao encontrado"));
        venda = definirVendaAberta(vendedor, venda);

        return vendaRepository.save(venda);
    }
}
