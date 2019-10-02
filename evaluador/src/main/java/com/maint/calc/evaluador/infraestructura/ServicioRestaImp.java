package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import org.springframework.stereotype.Component;

@Component
public class ServicioRestaImp implements RestaServicio {
    @Override
    public double calcular(double a, double b) {
        return a-b;
    }
}
