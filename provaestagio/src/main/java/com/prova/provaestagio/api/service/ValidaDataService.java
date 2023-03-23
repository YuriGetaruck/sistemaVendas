package com.prova.provaestagio.api.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

@AllArgsConstructor
@Service
public class ValidaDataService {

    public static boolean validaData(String dataInicial, String dataFinal){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("uuuu-MM-dd")
                .withResolverStyle(ResolverStyle.STRICT);

        try {
            LocalDate date1 = LocalDate.parse(dataInicial, dateTimeFormatter);
            LocalDate date2 = LocalDate.parse(dataFinal, dateTimeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
