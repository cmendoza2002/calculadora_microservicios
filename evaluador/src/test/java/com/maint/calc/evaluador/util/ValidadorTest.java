package com.maint.calc.evaluador.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidadorTest {

    @Test
    public void isValido() {
        Validador validador = new Validador();
        Assert.assertEquals(true,validador.isValido("1+1"));
        Assert.assertEquals(false,validador.isValido("1j1"));
        Assert.assertEquals(true,validador.isValido("1+1*1"));
        Assert.assertEquals(true,validador.isValido("(1+1)*1"));
        Assert.assertEquals(true,validador.isValido("(1+1)*(1-1)"));
        Assert.assertEquals(false,validador.isValido("(1+1)*(1-1))"));
        Assert.assertEquals(true,validador.isValido("(1*3-(2/8))-6"));
        Assert.assertEquals(true,validador.isValido("(5.5*3-(2/8))-6"));
    }

    @Test
    public void formatearSentencia() {
        Validador validador = new Validador();
        Assert.assertEquals("(1)*(1)",validador.formatearSentencia("(1)(1)"));
        Assert.assertEquals("1*(2)",validador.formatearSentencia("1(2)"));
        Assert.assertEquals("(1)*1",validador.formatearSentencia("(1)1"));
    }
}
