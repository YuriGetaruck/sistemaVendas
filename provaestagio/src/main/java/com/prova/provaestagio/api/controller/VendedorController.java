package com.prova.provaestagio.api.controller;

import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.api.repository.VendedorRepository;
import com.prova.provaestagio.api.service.CadastrarVendedorService;
import com.prova.provaestagio.api.service.DiasEntreDatasService;
import com.prova.provaestagio.api.service.ResumoVendedorNoPeriodoService;
import com.prova.provaestagio.api.service.VendasNoPeriodoService;
import com.prova.provaestagio.dtos.VendaResponse;
import com.prova.provaestagio.dtos.VendedorResponse;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private CadastrarVendedorService cadastrarVendedorService;

    @Autowired
    private VendedorRepository vendedorRepository;

//    @Autowired
//    private VendaRepository vendaRepository;
//
//    @Autowired
//    private VendasNoPeriodoService vendasNoPeriodoService;

    @Autowired
    private ResumoVendedorNoPeriodoService resumoVendedorNoPeriodoService;

    @GetMapping
    public List<Vendedor> listVendedores(){
        return vendedorRepository.findAll().stream().toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor cadastraVendedor(@Valid @RequestBody Vendedor vendedor){
        return cadastrarVendedorService.cadastrarVendedor(vendedor);
    }

    @GetMapping("/{dataInicial}/{dataFinal}")
    public List<VendedorResponse> resumoVendedor(@PathVariable String dataInicial, @PathVariable String dataFinal){

//        long diasNoPerido = DiasEntreDatasService.diasNoPeriodo(dataInicial, dataFinal);
//        List<Venda> vendasNoPerido = vendasNoPeriodoService.vedasNoPeriodo(dataInicial, dataFinal);
//        List<Vendedor> vendedores = vendedorRepository.findAll().stream().toList();
//        List<VendedorResponse> vendedorResponses = new ArrayList<>();
//
//        for (Vendedor vendedor: vendedores) {
//            List<Venda> vendasDoVendedor = new ArrayList<>();
//            for (Venda venda: vendasNoPerido) {
//                if(venda.getVendedor().getId().equals(vendedor.getId())){
//                    vendasDoVendedor.add(venda);
//                }
//            }
//            VendedorResponse vendedorResponse = new VendedorResponse(vendasDoVendedor, Double.valueOf(diasNoPerido));
//            vendedorResponses.add(vendedorResponse);
//        }
//
//        return vendedorResponses;

        return resumoVendedorNoPeriodoService.resumoVendedor(dataInicial, dataFinal);
    }
}
