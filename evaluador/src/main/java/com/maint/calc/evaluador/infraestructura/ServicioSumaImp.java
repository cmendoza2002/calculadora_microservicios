package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.infraestructura.feing.SumaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ServicioSumaImp  implements SumaServicio {

    @Autowired
    private SumaClient client;

    @Override
    public double calcular(double a, double b) {
        return client.sumar(a,b);
    }
}
