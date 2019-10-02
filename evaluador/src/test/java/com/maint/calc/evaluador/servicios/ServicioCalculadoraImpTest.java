package com.maint.calc.evaluador.servicios;


import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class ServicioCalculadoraImpTest {

    @InjectMocks
    private ServicioCalculadoraImp servicioCalculadora;


    @Mock
    private SumaClient sumaClient;

    @Mock
    private SumaServicio sumaServicio;

    @Mock
    private RestaServicio restaServicio;

    @Mock
    private MultiplicacionServicio multiplicacionServicio;

    @Mock
    private DivisionServicio divisionServicio;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        when(sumaClient.sumar(any())).thenReturn(4d);
    }



    @Test
    public void evaluar() {

       double resultado = servicioCalculadora.evaluar("2+2");
       //assertEquals(4L,resultado,0.001);
    }
}
