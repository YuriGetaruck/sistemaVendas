package com.prova.provaestagio.comum;

import com.prova.provaestagio.exception.ValidacaoException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DataServiceTest {

    @Autowired
    private DataService dataService;

    @Test
    public void deveRetorarNumeroDeDiasEntreDatasMais1() {
        Assertions.assertThat(DataService.diasNoPeriodo("2023-03-10", "2023-03-11"))
                .isEqualTo(2);
    }

    @Test
    public void deveRetornarUmSePassadoMesmoDiaEmAmbasDatas(){
        Assertions.assertThat(DataService.diasNoPeriodo("2023-03-10", "2023-03-10"))
                .isEqualTo(1);
    }

    @Test
    public void deveRetornarExceptionAoEnviarDataInvalida(){
        Assertions.catchException(() -> dataService.validaDataValida("2023-03-20", "2023-14-20"));
    }

    @Test
    public void deveRetornarExececaoAoEnviarDataNaoSequencial(){
        Assertions.assertThatExceptionOfType(ValidacaoException.class)
                .isThrownBy(() -> DataService.diasNoPeriodo("2023-03-20", "2022-03-20"))
                .withMessage("Data invalida");
    }

}
