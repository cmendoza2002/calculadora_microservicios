package com.maint.calc.evaluador.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ServicioCalculadoraImp implements ServicioCalculadora{

    @Autowired
    private SumaClient sumaClient;


    @Override
    public double sumar(double a, double b) {
        double[] numeros = {a,b};
        System.out.println("ssssssssssssssssssssssssssssssssssssssssss");
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
