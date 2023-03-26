package com.prova.provaestagio.dtos;

import com.prova.provaestagio.enums.EStatusVenda;
import com.prova.provaestagio.helper.Helper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static com.prova.provaestagio.helper.Helper.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Sql({"classpath:populaBancoDeDadosParaTestes.sql"})
@Transactional
public class VendaResponseTest {
    @Test
    public void deveRetornarUmaVendaResponse(){
        var respostaVenda = VendaResponse.of(umaVendaParaVendaResponseTeste());

        Assertions.assertThat(respostaVenda)
                .extracting( "id", "valor", "statusVenda")
                .contains(9999L, 99999.99, EStatusVenda.ABERTA);

        Assertions.assertThat(respostaVenda.getDataVenda()).isNotNull();

    }
}
