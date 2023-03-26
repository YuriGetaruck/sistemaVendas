package com.prova.provaestagio.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.prova.provaestagio.helper.Helper.umVendedorParaTeste;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql({"classpath:populaBancoDeDadosParaTestes.sql"})
@Transactional
public class VendedorServiceTest {


    @Autowired
    private VendedorService vendedorService;

    @Test
    public void deveListarTodosOsVendedores() {
        var vendedores = vendedorService.buscarTodosVendedores();
        assertThat(vendedores.size()).isEqualTo(3);
    }

    @Test
    public void deveCadastrarVendedor() {
        var vendedor = vendedorService.cadastrarVendedor(umVendedorParaTeste());
        assertThat(vendedor).extracting("nome", "CPF")
                .contains("Vendedor Gerado Por Teste", "999.999.999-99");

    }

    @Test
    public void deveRetornarResumoVendedoresCadastrados() {
        var resumoVendedore = vendedorService.resumoVendedores("2023-03-21", "2023-03-22");

        assertThat(resumoVendedore.size()).isEqualTo(3);
    }

    @Test
    public void deveRetornarNumeroDeVendasDoVendedorNoPeriodo() {
        var resumoVendedore = vendedorService.resumoVendedores("2023-03-21", "2023-03-22");

        assertThat(resumoVendedore.get(0).getTotalDeVendasNoPeriodo()).isEqualTo(4);

    }

    @Test
    public void deveRetornarMediaDiaraDeVendasDoVendedor() {
        var resumoVendedore = vendedorService.resumoVendedores("2023-03-21", "2023-03-22");

        assertThat(resumoVendedore.get(0).getMediaDeVendasDiariasNoPeriodo()).isEqualTo(2);
    }
}
