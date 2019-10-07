package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.infraestructura.DivisionServicioImp;
import com.maint.calc.evaluador.infraestructura.MultiplicacionServicioImp;
import com.maint.calc.evaluador.infraestructura.ServicioRestaImp;
import com.maint.calc.evaluador.infraestructura.ServicioSumaImp;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import com.maint.calc.evaluador.util.Validador;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
       // when(sumaClient.sumar(any())).thenReturn(4d);
    }

    @Test
    public void getResultado() {
        String expresion =  "2+2";
        Calculadora calculadora = new Calculadora(sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);
        double res = calculadora.calcularExpresion(expresion);
        //assertEquals(4,res,0.001);

        expresion = "2*((-2*4)/9)";
        //calculadora.calcularExpresion(expresion);
        /*System.out.println("Resultado: " + calculadora.evaluarExpresion(expresion));

        String[] sentencias = {
                "1+1",
                "23*(9-8)",
                "*2",
                "2*2*2*2*2",
                "1234$",
                "23(9*(9)"
        };

        for(String sentencia:sentencias){
            calculadora.evaluarExpresion(sentencia);
            if(validador.isValido(sentencia)){
                System.out.println("Sentencia " + sentencia + " valida");
                System.out.println("Resultado: " + calculadora.evaluarExpresion(sentencia));
            } else {
                System.out.println("Sentencia " + sentencia + " no valida");
            }
        }*/

    }




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
