package com.maint.calc.evaluador.servicios;

import com.maint.calc.evaluador.calculo.Calculadora;
import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioCalculadoraImp implements ServicioCalculadora{


    @Autowired
    SumaServicio  sumaServicio;
    @Autowired
    RestaServicio restaServicio;
    @Autowired
    MultiplicacionServicio multiplicacionServicio;
    @Autowired
    DivisionServicio divisionServicio;



    public double evaluar(String expresion)
    {
        Calculadora calculadora = new Calculadora(sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);
        calculadora.setSentencia(expresion);
        return calculadora.getResultado();
    }




    @Override
    public double sumar(double a, double b) {
        double[] numeros = {a,b};
        return sumaServicio.calcular(a,b);
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
