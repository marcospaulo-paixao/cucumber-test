package br.dev.mpp.cucumbertest.calculadora;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public int somar(Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }

    public int subtrair(Integer numero1, Integer numero2) {
        return numero1 - numero2;
    }
}
