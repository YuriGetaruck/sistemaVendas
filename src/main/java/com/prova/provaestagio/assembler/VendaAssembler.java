package com.prova.provaestagio.assembler;

import com.prova.provaestagio.api.model.VendaModel;
import com.prova.provaestagio.models.Venda;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class VendaAssembler {
//
//    private ModelMapper modelMapper;
//
//    public VendaModel toModel(Venda venda){
//        return modelMapper.map(venda, VendaModel.class);
//    }
//
//    public Venda toEntity(VendaModel vendaModel){
//        return modelMapper.map(vendaModel, Venda.class);
//    }
//
//    public List<VendaModel> toCollectionModel(List<Venda> vendas){
//        return vendas.stream().map(this::toModel).collect(Collectors.toList());
//    }
}
