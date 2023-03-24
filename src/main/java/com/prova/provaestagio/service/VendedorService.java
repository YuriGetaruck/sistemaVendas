package com.prova.provaestagio.service;

import com.prova.provaestagio.comum.DataService;
import com.prova.provaestagio.dtos.VendedorResponse;
import com.prova.provaestagio.dtos.VendedorResumoResponse;
import com.prova.provaestagio.model.Venda;
import com.prova.provaestagio.repository.VendedorRepository;
import com.prova.provaestagio.model.Vendedor;
import lombok.AllArgsConstructor;
import org.aspectj.util.GenericSignature;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VendedorService {

    private VendedorRepository vendedorRepository;

    private VendaService vendaService;

    @Transactional
    public Vendedor cadastrarVendedor(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    @Transactional
    public List<VendedorResponse> buscarTodosVendedores(){
        return vendedorRepository.findAll().stream().map(VendedorResponse::of).toList();
    }

    @Transactional
    public List<VendedorResumoResponse> resumoVendedor(@PathVariable String dataInicial, @PathVariable String dataFinal){

        var diasNoPerido = DataService.diasNoPeriodo(dataInicial, dataFinal);
        var vendasNoPerido = vendaService.vendasNoPeriodo(dataInicial, dataFinal);
        var vendedores = vendedorRepository.findAll().stream().toList();
        //var vendedorResponses = new ArrayList<VendedorResumoResponse>();
//        var vendedorResponses = Arrays.asList(VendedorResumoResponse.class);


//        for (Vendedor vendedor: vendedores) {
//            List<Venda> vendasDoVendedor = new ArrayList<>();
//            for (Venda venda: vendasNoPerido) {
//                if(venda.getVendedor().getId().equals(vendedor.getId())){
//                    vendasDoVendedor.add(venda);
//                }
//            }
//            VendedorResumoResponse vendedorResponse = new VendedorResumoResponse(vendasDoVendedor, Double.valueOf(diasNoPerido));
//            vendedorResponses.add(vendedorResponse);
//        }


        return vendedores.stream()
                .map(vendedor -> {
                    List<Venda> vendasDoVendedor = vendasNoPerido.stream()
                            .filter(venda -> venda.getVendedor().getId().equals(vendedor.getId()))
                            .collect(Collectors.toList());
                    return new VendedorResumoResponse(vendasDoVendedor, Double.valueOf(diasNoPerido));
                })
                .collect(Collectors.toList());
    }


}
