package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.infraestructura.feing.MultiplicacionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiplicacionServicioImp implements MultiplicacionServicio {
    @Autowired
    private MultiplicacionClient client;

    @Override
    public double calcular(double a, double b) {
        return client.multiplicar(a,b);
        //return a*b;
    }
}
