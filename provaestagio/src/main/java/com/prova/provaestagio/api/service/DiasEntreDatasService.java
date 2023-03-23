package com.prova.provaestagio.api.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Service
public class DiasEntreDatasService {

    public static long diasNoPeriodo(String dataInicial, String dataFinal){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date1 = LocalDate.parse(dataInicial, dateTimeFormatter);
            LocalDate date2 = LocalDate.parse(dataFinal, dateTimeFormatter);

            if(dataInicial.equals(dataFinal)){
                return 1;
            } else return ChronoUnit.DAYS.between(date1, date2) + 1;
        } catch (DateTimeParseException e) {
            return 0;
        }


    }

}
