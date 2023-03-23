package com.prova.provaestagio.api.service;

import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.api.repository.VendedorRepository;
import com.prova.provaestagio.exception.NegocioException;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.model.Vendedor;
import com.prova.provaestagio.model.enums.StatusVenda;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;



@AllArgsConstructor
@Service
public class SolicitacaoVendaService {

    private VendaRepository vendaRepository;

    private VendedorRepository vendedorRepository;

    @Transactional
    public Venda gerarVenda(Venda venda){

        Vendedor vendedor = vendedorRepository.findById(venda.getVendedor().getId()).orElseThrow(() -> new NegocioException("Vendedor nao encontrado"));

        venda.setVendedor(vendedor);
        venda.setVendaDate(OffsetDateTime.now());
        venda.setStatusVenda(StatusVenda.ABERTA);
        return vendaRepository.save(venda);
    }

}
