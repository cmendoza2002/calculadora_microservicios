package com.maint.calc.evaluador;

import com.maint.calc.evaluador.api.EvaluadorRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora/v1/evaluador")
@Api(value="calculadora/v1/evaluador")
public class EvaluadorController {

    @ApiOperation(value = "Evaluar expresion para procesar la operacion.",response = EvaluadorRequest.class)
    @RequestMapping(value = "/evaluar", method = RequestMethod.POST)
    public boolean evaluarExprecion(@RequestBody EvaluadorRequest request)
    {
        java.util.regex.Pattern pattern =
                java.util.regex.Pattern.compile("(\\(*[0-9]+[+\\-*][0-9]\\)*)+([+\\-*][0-9])*");
        java.util.regex.Matcher matcher = pattern.matcher(request.getExpresion());
        return matcher.matches();
    }
}
