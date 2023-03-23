package com.prova.provaestagio.api.service;

import com.prova.provaestagio.api.repository.VendedorRepository;
import com.prova.provaestagio.model.Vendedor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastrarVendedorService {

    private VendedorRepository vendedorRepository;

    @Transactional
    public Vendedor cadastrarVendedor(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }
}
