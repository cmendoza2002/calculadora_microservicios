package com.maint.calc.evaluador.util;

import com.maint.calc.evaluador.calculo.Calculadora;
import com.maint.calc.evaluador.servicios.ServicioCalculadora;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidadorTest {

    @Autowired
    ServicioCalculadora servicioCalculadora;


    @Test
    public void isValido() {
        String expresion = "2*((-2*4)/9)";
        Calculadora calculadora = new Calculadora(servicioCalculadora);
        calculadora.setSentencia(expresion);
        System.out.println("Resultado: " + calculadora.getResultado());
        System.out.println("Notacion: " + calculadora.getNotacion());


        String[] sentencias = {
                "1+1",
                "23*(9-8)",
                "*2",
                "2*2*2*2*2",
                "1234$",
                "23(9*(9)"
        };

        for(String sentencia:sentencias){
            calculadora.setSentencia(sentencia);
            if(calculadora.isValido()){
                System.out.println("Sentencia " + sentencia + " valida");
                System.out.println("Resultado: " + calculadora.getResultado());
                System.out.println("Notacion: " + calculadora.getNotacion());
            } else {
                System.out.println("Sentencia " + sentencia + " no valida");
                System.out.println("Valor no valido detalles: " + calculadora.showValidacion());
            }
        }


        Assert.assertEquals(true,Validador.getInstancia().isValido("1+1"));
        Assert.assertEquals(false,Validador.getInstancia().isValido("1j1"));
        Assert.assertEquals(true,Validador.getInstancia().isValido("1+1*1"));
        Assert.assertEquals(true,Validador.getInstancia().isValido("(1+1)*1"));
        Assert.assertEquals(true,Validador.getInstancia().isValido("(1+1)*(1-1)"));
        Assert.assertEquals(false,Validador.getInstancia().isValido("(1+1)*(1-1))"));
        Assert.assertEquals(true,Validador.getInstancia().isValido("(1*3-(2/8))-6"));
        Assert.assertEquals(true,Validador.getInstancia().isValido("(5.5*3-(2/8))-6"));
    }

    @Test
    public void formatearSentencia() {
        Assert.assertEquals("(1)*(1)",Validador.getInstancia().formatearSentencia("(1)(1)"));
        Assert.assertEquals("1*(2)",Validador.getInstancia().formatearSentencia("1(2)"));
        Assert.assertEquals("(1)*1",Validador.getInstancia().formatearSentencia("(1)1"));
    }
}
