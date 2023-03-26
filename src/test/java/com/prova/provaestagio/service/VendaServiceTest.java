package com.prova.provaestagio.service;


import com.prova.provaestagio.enums.EStatusVenda;
import com.prova.provaestagio.exception.NegocioException;
import com.prova.provaestagio.helper.Helper;
import com.prova.provaestagio.model.Venda;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.prova.provaestagio.helper.Helper.*;
import static org.assertj.core.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql({"classpath:populaBancoDeDadosParaTestes.sql"})
@Transactional
public class VendaServiceTest {

    @Autowired
    private VendaService vendaService;


    @Test
    public void deveListarTodasAsVendas() {
        var vendas = vendaService.buscarTodasVendas();

        assertThat(vendas.size()).isEqualTo(16);
    }

    @Test
    public void deveRetornarVendaNoPeriodo(){
        var vendas = vendaService.vendasNoPeriodo("2023-03-21", "2023-03-22");

        assertThat(vendas.size()).isEqualTo(11);
    }

    @Test
    public void deveCadastrarVendaSucesso(){
        var venda =  vendaService.gerarVenda(umaVendaParaTeste());

        assertThat(venda)
                .extracting( "vendedor.id", "statusVenda")
                .contains(1L, EStatusVenda.ABERTA);

        assertThat(venda.getVendaDate()).isNotNull();
    }

    @Test
    public void naoDeveCadastrarVendaComVendedorInvalido(){
        assertThatExceptionOfType(NegocioException.class)
                .isThrownBy(() -> vendaService.gerarVenda(umaVendaParaTesteComVendedorInvalido()))
                .withMessage("Vendedor nao encontrado");
    }





}
