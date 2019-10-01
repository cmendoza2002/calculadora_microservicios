package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.servicios.ServicioCalculadora;
import com.maint.calc.evaluador.util.Validador;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraTest {
    @Autowired
    ServicioCalculadora servicioCalculadora;

    @Test
    public void getResultado() {
        String expresion = "2*((-2*4)/9)";
        Calculadora calculadora = new Calculadora(servicioCalculadora);
        calculadora.setSentencia(expresion);
        double res = calculadora.getResultado();
        Assert.assertEquals(-1.7777777777777777,res,0.001);

    }
}
