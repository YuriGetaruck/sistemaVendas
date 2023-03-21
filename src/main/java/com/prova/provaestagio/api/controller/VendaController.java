package com.prova.provaestagio.api.controller;


import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.api.service.SolicitacaoVendaService;
import com.prova.provaestagio.models.Venda;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {


    private SolicitacaoVendaService solicitacaoVendaService;

    private VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> listSales(){
        return vendaRepository.findAll().stream().toList();
    }


}
