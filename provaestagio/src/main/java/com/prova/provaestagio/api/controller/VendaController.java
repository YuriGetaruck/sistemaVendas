package com.prova.provaestagio.api.controller;


import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.api.service.SolicitacaoVendaService;
import com.prova.provaestagio.api.service.VendasNoPeriodoService;
import com.prova.provaestagio.model.Venda;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendaController {


    @Autowired
    private SolicitacaoVendaService solicitacaoVendaService;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendasNoPeriodoService vendasNoPeriodoService;

    @GetMapping
    public List<Venda> listVendas(){
        return vendaRepository.findAll().stream().toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda criaVenda(@Valid @RequestBody Venda venda){
        return solicitacaoVendaService.gerarVenda(venda);
    }
    @GetMapping("/{dataInicial}/{dataFinal}")
    public List<Venda> vendasDeAte(@PathVariable String dataInicial, @PathVariable String dataFinal){
        return vendasNoPeriodoService.vedasNoPeriodo(dataInicial,dataFinal);
    }
}
