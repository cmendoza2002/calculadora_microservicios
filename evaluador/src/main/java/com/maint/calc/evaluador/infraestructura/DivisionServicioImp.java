package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.infraestructura.feing.DivisionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DivisionServicioImp implements DivisionServicio {
    @Autowired
    DivisionClient client;

    @Override
    public double calcular(double a, double b) {
        return client.dividir(a,b);
    }
}
