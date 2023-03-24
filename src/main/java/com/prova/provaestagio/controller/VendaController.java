package com.prova.provaestagio.controller;


import com.prova.provaestagio.dtos.VendaResponse;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("listar")
    public List<VendaResponse> listVendas() {
        return vendaService.buscarTodasVendas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criaVenda(@Valid @RequestBody Venda venda) {
        vendaService.gerarVenda(venda);
    }

    @GetMapping("{dataInicial}/{dataFinal}")
    public List<Venda> vendasDeAte(@PathVariable String dataInicial, @PathVariable String dataFinal) {
        return vendaService.vendasNoPeriodo(dataInicial, dataFinal);
    }


}
