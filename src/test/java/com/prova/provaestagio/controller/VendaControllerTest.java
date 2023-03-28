package com.prova.provaestagio.controller;

import com.prova.provaestagio.helper.Helper;
import com.prova.provaestagio.model.Vendedor;
import com.prova.provaestagio.service.VendaService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class VendaControllerTest {

    private static final String ENDPOINT = "/venda";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private VendaService vendaService;

    @Test
    public void deveRetornarStatusCreatedDeVenda() throws Exception {

        vendedorService.cadastrarVendedor(Vendedor.builder()
                .nome("Vendedor TesteController")
                .CPF("999.999.999-99")
                .build());

        mvc.perform(post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Helper.converteParaJsonBytes(Helper.umaVendaParaControllerTest())))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void deveListarTodasVendas() throws Exception{

        mvc.perform(get(ENDPOINT + "/listar"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());

    }

    @Test
    public void deveListarVendasPorPeriodo() throws Exception {

        mvc.perform(get(ENDPOINT + "/2023-03-22/2023-03-26"))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void deveLancarExcecaoAoRegistrarVendaComVendedorInvalido() throws Exception {
        mvc.perform(post(ENDPOINT))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

}
