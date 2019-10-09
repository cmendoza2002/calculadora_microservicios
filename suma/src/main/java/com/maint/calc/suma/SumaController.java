package com.maint.calc.suma;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SumaController {

    @RequestMapping(value="/sumar", method= RequestMethod.GET)
    public ResponseEntity<Double> sumar(@RequestParam("a") double a, @RequestParam("b") double b)
    {
        double total = a + b;
        return new ResponseEntity<>(total, HttpStatus.OK);
    }



}
