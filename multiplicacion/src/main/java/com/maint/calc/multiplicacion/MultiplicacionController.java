package com.maint.calc.multiplicacion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicacionController {
    @RequestMapping(value="/multiplicar", method= RequestMethod.GET)
    public ResponseEntity<Double> multiplicar(@RequestParam("a") double a, @RequestParam("b") double b)
    {
        double total = a * b;
        return new ResponseEntity<>(total, HttpStatus.OK);
    }
}
