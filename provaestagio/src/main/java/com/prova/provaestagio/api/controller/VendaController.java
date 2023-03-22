package com.prova.provaestagio.api.controller;


import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.api.service.SolicitacaoVendaService;
import com.prova.provaestagio.models.Venda;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {


    private SolicitacaoVendaService solicitacaoVendaService;

    private VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> listVendas(){
        return vendaRepository.findAll().stream().toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda criaVenda(@Valid @RequestBody Venda venda){
        return solicitacaoVendaService.gerarVenda(venda);
    }

}
