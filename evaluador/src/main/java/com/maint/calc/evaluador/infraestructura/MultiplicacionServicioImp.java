package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;

public class MultiplicacionServicioImp implements MultiplicacionServicio {
    @Override
    public double calcular(double a, double b) {
        return a*b;
    }
}
