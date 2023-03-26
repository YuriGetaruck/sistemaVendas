package com.prova.provaestagio.repository;


import com.prova.provaestagio.comum.DataService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
@Sql({"classpath:populaBancoDeDadosParaTestes.sql"})
@Transactional
public class VendasRepositoryTest {

    @Autowired
    private VendaRepository vendaRepository;

    @Test
    public void deveRetornarAsVendasEntreDatas(){
        var vendasEntreDatas = vendaRepository.findByVendaDateBetween(
                OffsetDateTime.parse("2023-03-21" + "T00:00:00.000000000-03:00"),
                OffsetDateTime.parse("2023-03-22" + "T23:59:59.990000000-03:00"));

        Assertions.assertThat(vendasEntreDatas.size()).isEqualTo(11);
    }

}
