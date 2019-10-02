package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.infraestructura.DivisionServicioImp;
import com.maint.calc.evaluador.infraestructura.MultiplicacionServicioImp;
import com.maint.calc.evaluador.infraestructura.ServicioRestaImp;
import com.maint.calc.evaluador.infraestructura.ServicioSumaImp;
import com.maint.calc.evaluador.servicios.ServicioCalculadoraImp;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CalculadoraTest {

    @InjectMocks
    ServicioSumaImp sumaServicio;
    @InjectMocks
    ServicioRestaImp restaServicio;
    @InjectMocks
    MultiplicacionServicioImp multiplicacionServicio;
    @InjectMocks
    DivisionServicioImp divisionServicio;


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
        Calculadora calculadora = new Calculadora(sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);
        calculadora.setSentencia(expresion);
        double res = calculadora.getResultado();
        Assert.assertEquals(4,res,0.001);

        expresion = "2*((-2*4)/9)";
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

    }




    @Test
    public void testGetResultado() {

          SumaServicio sumaServicio = (x,y) -> x+y;
          RestaServicio restaServicio  = (x,y) -> x-y;
          MultiplicacionServicio multiplicacionServicio =   (x,y) -> x*y;
          DivisionServicio divisionServicio =  (x,y) -> x/y;


        Calculadora calculadora = new Calculadora(sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);
        calculadora.setSentencia("2+2");
        assertEquals(4.0,calculadora.getResultado(),0.00001);



        calculadora.setSentencia("(10+10)/20");
        assertEquals(1.0,calculadora.getResultado(),0.00001);


        calculadora.setSentencia("(10+10+10)/3");
        assertEquals(10.0,calculadora.getResultado(),0.00001);


        calculadora.setSentencia("(10*10*10)/20");
        assertEquals(50.0,calculadora.getResultado(),0.00001);



    }
}
