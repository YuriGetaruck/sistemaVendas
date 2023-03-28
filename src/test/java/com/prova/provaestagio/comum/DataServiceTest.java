package com.prova.provaestagio.comum;

import com.prova.provaestagio.exception.ValidacaoException;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataServiceTest {

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
        Assertions.catchException(() -> DataService.validaDataValida("2023-03-20", "2023-14-20"));
    }

    @Test
    public void deveRetornarExececaoAoEnviarDataNaoSequencial(){
        Assertions.assertThatExceptionOfType(ValidacaoException.class)
                .isThrownBy(() -> DataService.diasNoPeriodo("2023-03-20", "2022-03-20"))
                .withMessage("Data invalida");
    }

}
