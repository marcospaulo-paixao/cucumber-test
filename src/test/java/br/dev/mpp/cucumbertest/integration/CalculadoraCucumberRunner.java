package br.dev.mpp.cucumbertest.integration;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@calculadora",// Caminho para os arquivos .feature
        glue = "br.dev.mpp.cucumbertest.integration.steps", // Pacote onde estão os step definitions
        plugin = {"pretty", "json:target/cucumber-reports.json"} // Relatórios de execução
)
public class CalculadoraCucumberRunner {
}
