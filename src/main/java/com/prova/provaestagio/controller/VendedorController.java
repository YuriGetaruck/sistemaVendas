package com.prova.provaestagio.controller;

import com.prova.provaestagio.dtos.VendedorResponse;
import com.prova.provaestagio.dtos.VendedorResumoResponse;
import com.prova.provaestagio.model.Vendedor;
import com.prova.provaestagio.service.VendedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping("listar")
    public List<VendedorResponse> listVendedores() {
        return vendedorService.buscarTodosVendedores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraVendedor(@Valid @RequestBody Vendedor vendedor) {
        vendedorService.cadastrarVendedor(vendedor);
    }

    @GetMapping("{dataInicial}/{dataFinal}")
    public List<VendedorResumoResponse> resumoVendedor(@PathVariable String dataInicial, @PathVariable String dataFinal) {
        return vendedorService.resumoVendedor(dataInicial, dataFinal);
    }
}
