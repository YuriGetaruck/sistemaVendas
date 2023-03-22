package com.prova.provaestagio.api.service;

import com.prova.provaestagio.api.repository.VendaRepository;
import com.prova.provaestagio.models.Produto;
import com.prova.provaestagio.models.Venda;
import com.prova.provaestagio.models.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.OffsetDateTime;



@AllArgsConstructor
@Service
public class SolicitacaoVendaService {

    private VendaRepository vendaRepository;

    @Transactional
    public Venda gerarVenda(Venda venda){
        venda.setDataVenda(OffsetDateTime.now());
        return vendaRepository.save(venda);
    }

}
