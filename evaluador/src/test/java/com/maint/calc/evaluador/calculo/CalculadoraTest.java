package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.servicios.ServicioCalculadoraImp;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraTest {
    //@Autowired

    @InjectMocks
    private ServicioCalculadoraImp servicioCalculadora;


    @Mock
    private SumaClient sumaClient;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        when(sumaClient.sumar(any())).thenReturn(4d);


    }

    @Test
    public void getResultado() {
        //String expresion = "2*((-2*4)/9)";
        String expresion =  "2+2";
        Calculadora calculadora = new Calculadora(servicioCalculadora);
        calculadora.setSentencia(expresion);
        double res = calculadora.getResultado();
        Assert.assertEquals(4,res,0.001);

    }
}
