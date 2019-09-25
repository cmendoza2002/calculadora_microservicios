package com.maint.calc.suma;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class SumaController {

    @RequestMapping(value="/suma", method= RequestMethod.GET)
    public ResponseEntity<BigDecimal> sumar(@RequestParam("n") BigDecimal[] array)
    {

        BigDecimal total = BigDecimal.ZERO;
        for(int i = 0 ; i <   array.length ; i++ )
        {
            total = total.add(array[i]);
        }

        return new ResponseEntity<>(total, HttpStatus.OK);
    }



}
