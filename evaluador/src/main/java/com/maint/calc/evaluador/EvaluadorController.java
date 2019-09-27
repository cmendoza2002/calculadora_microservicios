package com.maint.calc.evaluador;

import com.maint.calc.evaluador.api.EvaluadorRequest;
import com.maint.calc.evaluador.api.EvaluadorResponse;
import com.maint.calc.evaluador.util.Validador;
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
    public EvaluadorResponse evaluarExpresion(@RequestBody EvaluadorRequest request)
    {

        return Validador.getInstancia().isValido(request.getExpresion())?
                new EvaluadorResponse(EvaluadorResponse.TipoRespuesta.EXITO):
                new EvaluadorResponse(EvaluadorResponse.TipoRespuesta.ERROR,Validador.getInstancia().getValidacion(request.getExpresion()));
    }
}
