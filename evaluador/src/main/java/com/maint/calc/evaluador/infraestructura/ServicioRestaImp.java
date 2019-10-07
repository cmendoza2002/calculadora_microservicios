package com.maint.calc.evaluador.infraestructura;

import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.infraestructura.feing.RestaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicioRestaImp implements RestaServicio {
    @Autowired
    private RestaClient client;
    @Override
    public double calcular(double a, double b) {

        //return a-b;
        return client.restar(a,b);
    }
}
