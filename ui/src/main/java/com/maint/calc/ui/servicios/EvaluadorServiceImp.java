package com.maint.calc.ui.servicios;

import com.maint.calc.ui.infraestructura.EvaluadorRequest;
import com.maint.calc.ui.infraestructura.OperacionResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EvaluadorServiceImp implements EvaluadorService{



    @Override
    public double procesar(String expresion) {
        RestTemplate restTemplate = new RestTemplate();
        OperacionResponse response = restTemplate.postForObject("http://localhost:9090/calculadora/v1/evaluador/procesar",new EvaluadorRequest(expresion), OperacionResponse.class);
        return response.getResultado();
    }
}
