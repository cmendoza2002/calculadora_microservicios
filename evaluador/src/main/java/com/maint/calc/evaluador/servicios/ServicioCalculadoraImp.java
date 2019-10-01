package com.maint.calc.evaluador.servicios;

import com.maint.calc.evaluador.calculo.Calculadora;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioCalculadoraImp implements ServicioCalculadora{





    public double evaluar(String exprecion)
    {
        Calculadora calculadora = new Calculadora(sumaClient);
    }




    @Override
    public double sumar(double a, double b) {
        double[] numeros = {a,b};
        return sumaClient.sumar(numeros);
    }

    @Override
    public double restar(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
        return a / b;
    }
}
