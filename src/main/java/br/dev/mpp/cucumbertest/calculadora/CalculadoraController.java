package br.dev.mpp.cucumbertest.calculadora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @PostMapping("somar/{numero1}/{numero2}")
    public ResponseEntity<?> somar(@PathVariable("numero1") int numero1,
                                   @PathVariable("numero2") int numero2) {
        int soma = this.calculadoraService.somar(numero1, numero2);
        return ResponseEntity.ok(new HashMap<>() {{
            put("resultado", soma);
        }});
    }

    @PostMapping("subtrair/{numero1}/{numero2}")
    public ResponseEntity<?> subtrair(@PathVariable("numero1") int numero1,
                                   @PathVariable("numero2") int numero2) {
        int soma = this.calculadoraService.subtrair(numero1, numero2);
        return ResponseEntity.ok(new HashMap<>() {{
            put("resultado", soma);
        }});
    }
}
