package com.maint.calc.evaluador;

import com.maint.calc.evaluador.rest.EvaluadorRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class EvaluadorController {

    @RequestMapping(value = "/evaluar", method = RequestMethod.POST)
    public boolean evaluarExprecion(@RequestBody EvaluadorRequest request)
    {
        java.util.regex.Pattern pattern =
                java.util.regex.Pattern.compile("(\\(*[0-9]+[+\\-*][0-9]\\)*)+([+\\-*][0-9])*");
        java.util.regex.Matcher matcher = pattern.matcher(request.getExpresion());
        return matcher.matches();
    }
}
