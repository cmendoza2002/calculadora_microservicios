package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import org.springframework.stereotype.Component;

@Component
public class DivisionServicioImp implements DivisionServicio {
    @Override
    public double calcular(double a, double b) {
        return a/b;
    }
}
