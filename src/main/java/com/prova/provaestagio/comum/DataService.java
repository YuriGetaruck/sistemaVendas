package com.prova.provaestagio.comum;

import com.prova.provaestagio.exception.ValidacaoException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;


@Service
public class DataService {

    public static long diasNoPeriodo(String dataInicial, String dataFinal) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            var date1 = LocalDate.parse(dataInicial, dateTimeFormatter);
            var date2 = LocalDate.parse(dataFinal, dateTimeFormatter);

            if (dataInicial.equals(dataFinal)) {
                return 1;
            } else if (ChronoUnit.DAYS.between(date1, date2 ) < 0) {
                throw new ValidacaoException("Datas invalida");
            } else return ChronoUnit.DAYS.between(date1, date2) + 1;
        } catch (ValidacaoException e) {
            throw new ValidacaoException("Data invalida");
        }
    }

    public void validaDataValida(String dataInicial, String dataFinal) {

        var dateTimeFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            var date1 = LocalDate.parse(dataInicial, dateTimeFormatter);
            var date2 = LocalDate.parse(dataFinal, dateTimeFormatter);
        } catch (ValidacaoException e) {
            throw new ValidacaoException("Data invalida");
        }
    }
}
