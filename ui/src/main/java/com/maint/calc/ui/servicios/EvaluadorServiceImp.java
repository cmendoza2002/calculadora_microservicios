package com.maint.calc.ui.servicios;

import com.maint.calc.ui.infraestructura.EvaluadorRequest;
import com.maint.calc.ui.infraestructura.OperacionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EvaluadorServiceImp implements EvaluadorService {

    @Value("${gateway.url:192.168.7.130:9090}")
    private String apiServerIp;

    @Override
    public double procesar(String expresion) {
        RestTemplate restTemplate = new RestTemplate();
        OperacionResponse response = restTemplate.postForObject(
                "http://" + apiServerIp + "/calculadora/v1/evaluador/procesar", new EvaluadorRequest(expresion),
                OperacionResponse.class);
        return response.getResultado();
    }
}
