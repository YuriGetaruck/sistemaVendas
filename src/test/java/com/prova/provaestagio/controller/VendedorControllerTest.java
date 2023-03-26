package com.prova.provaestagio.controller;


import com.prova.provaestagio.helper.Helper;
import com.prova.provaestagio.service.VendedorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.ExecutionException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class VendedorControllerTest {

    private static final String ENDPOINT = "/vendedor";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VendedorService vendedorService;

    @Test
    public void deveCadastrarVendedor() throws Exception {

        mvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(Helper.converteParaJsonBytes(Helper.umVendedorParaControllerTest())))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void deveListarTodosVendedores() throws Exception{

        mvc.perform(get(ENDPOINT + "/listar"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void deveListarResumoVendedoreNoPeriodo() throws Exception{

        mvc.perform(get(ENDPOINT + "/2023-03-22/2023-03-26"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

}
