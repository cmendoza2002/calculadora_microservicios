package com.maint.calc.evaluador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class EvaluadorController {

    @RequestMapping(value = "/evaluar", method = RequestMethod.GET)
    public BigDecimal evaluarExprecion(String expresion)
    {
        return BigDecimal.ZERO;
    }
}
