package com.prova.provaestagio.dtos;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.prova.provaestagio.helper.Helper.umVendedorParaVendedorResponseTeste;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql({"classpath:populaBancoDeDadosParaTestes.sql"})
@Transactional
public class VendedorResponseTest {

    @Test
    public void deveRetornarUmaVendedorResponse() {
        var respostaVendedor = VendedorResponse.of(umVendedorParaVendedorResponseTeste());

        Assertions.assertThat(respostaVendedor)
                .extracting("id", "nome")
                .contains(9999L, "Vendedor Gerado Por Teste Para VendedroResponseTest");
    }
}
