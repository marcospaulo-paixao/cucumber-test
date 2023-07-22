package br.dev.mpp.cucumbertest.integration.steps;


import br.dev.mpp.cucumbertest.CucumberTestApplication;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberTestApplication.class)
@AutoConfigureMockMvc(addFilters = false)
public class CalculadoraSteps {

    @Autowired
    private MockMvc mockMvc;
    private Integer numeroA;
    private Integer numeroB;
    private Integer numeroC;
    private Integer numeroD;

    @Dado("numero A")
    public void numero_a() {
        numeroA = 1;
    }

    @Dado("numero B")
    public void numero_b() {
        numeroB = 2;
    }

    @Quando("somar A + B")
    public void somar_a_b() {
        numeroC = numeroA + numeroB;
    }

    @Entao("o resultado e C")
    public void o_resultado_e_c() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(String.format("/calculadora/somar/%d/%d", numeroA, numeroB))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value(numeroC));
    }

    @Quando("subtrair A - B")
    public void subtrair_a_b() {
        numeroD = numeroA - numeroB;
    }

    @Entao("o resultado e D")
    public void o_resultado_e_d() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post(String.format("/calculadora/subtrair/%d/%d", numeroA, numeroB))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultado").value(numeroD));

    }


}
