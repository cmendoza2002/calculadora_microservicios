package com.maint.calc.evaluador.infraestructura.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SUMA-SERVICE")
public interface SumaClient {

    @GetMapping("/sumar")
    double sumar(@RequestParam("a") double a, @RequestParam("b") double b);
}
