package com.maint.calc.evaluador;

import com.maint.calc.evaluador.api.EvaluadorRequest;
import com.maint.calc.evaluador.api.EvaluadorResponse;
import com.maint.calc.evaluador.api.OperacionResponse;
import com.maint.calc.evaluador.calculo.CalculadoraException;
import com.maint.calc.evaluador.servicios.ServicioCalculadora;
import com.maint.calc.evaluador.util.Validador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora/v1/evaluador")
@Api(value="calculadora/v1/evaluador")
public class EvaluadorController {

    @Autowired
    private ServicioCalculadora servicioCalculadora;

    private Validador validador = new Validador();

    @ApiOperation(value = "Evaluar expresion para procesar la operacion.",response = EvaluadorRequest.class)
    @RequestMapping(value = "/validar", method = RequestMethod.POST)
    public EvaluadorResponse validarExpresion(@RequestBody EvaluadorRequest request)
    {
        return validador.isValido(request.getExpresion())?
                new EvaluadorResponse(EvaluadorResponse.TipoRespuesta.EXITO):
                new EvaluadorResponse(EvaluadorResponse.TipoRespuesta.ERROR,validador.getValidacion(request.getExpresion()));
    }

    @ApiOperation(value = "Evaluar expresion para procesar la operacion.",response = EvaluadorRequest.class)
    @RequestMapping(value = "/procesar", method = RequestMethod.POST)
    public OperacionResponse procesarExpresion(@RequestBody EvaluadorRequest request)
    {
        if(validador.isValido(request.getExpresion()))
        {
            try {
                double resultado = servicioCalculadora.evaluar(request.getExpresion());
                OperacionResponse response = new OperacionResponse(resultado);
                return response;
            }
            catch (CalculadoraException e)
            {
                return new OperacionResponse(EvaluadorResponse.TipoRespuesta.ERROR, e.getMessage());
            }
        }
        return new OperacionResponse(EvaluadorResponse.TipoRespuesta.ERROR,validador.getValidacion(request.getExpresion()));
    }
}
