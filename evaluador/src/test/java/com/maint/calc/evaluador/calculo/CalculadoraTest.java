package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    @Test
    public void testGetResultado() {

          SumaServicio sumaServicio = (x,y) -> x+y;
          RestaServicio restaServicio  = (x,y) -> x-y;
          MultiplicacionServicio multiplicacionServicio =   (x,y) -> x*y;
          DivisionServicio divisionServicio =  (x,y) -> x/y;

        Calculadora calculadora = new Calculadora(sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);

        assertEquals(4.0,calculadora.calcularExpresion("2+2"),0.00001);

        assertEquals(1.0,calculadora.calcularExpresion("(10+10)/20"),0.00001);

        assertEquals(10.0,calculadora.calcularExpresion("(10+10+10)/3"),0.00001);

        assertEquals(50.0,calculadora.calcularExpresion("(10*10*10)/20"),0.00001);

    }
}
