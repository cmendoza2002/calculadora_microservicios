package com.maint.calc.evaluador.infraestructura.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RESTA-SERVICE")
public interface RestaClient {

    @GetMapping("/restar")
    double restar(@RequestParam("a") double a, @RequestParam("b") double b);
}
