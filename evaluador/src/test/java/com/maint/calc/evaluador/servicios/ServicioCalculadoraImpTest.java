package com.maint.calc.evaluador.servicios;

import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class ServicioCalculadoraImpTest {

    @InjectMocks
    private ServicioCalculadoraImp servicioCalculadora;

    @Mock
    private SumaServicio sumaServicio;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        when(sumaServicio.calcular(2.0,2.0)).thenReturn(4.0);
        when(sumaServicio.calcular(4.0,0)).thenReturn(4.0);
    }



    @Test
    public void evaluar() {

       double resultado = servicioCalculadora.evaluar("2+2");
       assertEquals(4L,resultado,0.001);
    }
}
