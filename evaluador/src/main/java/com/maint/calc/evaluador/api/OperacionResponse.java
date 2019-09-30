package com.maint.calc.evaluador.api;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OperacionResponse {
    private EvaluadorResponse.TipoRespuesta tipoRespuesta;
    private String mensaje;
    private double resultado;

    public OperacionResponse(double resultado) {
        tipoRespuesta = EvaluadorResponse.TipoRespuesta.EXITO;
        this.resultado = resultado;
    }

    public OperacionResponse(EvaluadorResponse.TipoRespuesta tipoRespuesta, String mensaje) {
        this.tipoRespuesta = tipoRespuesta;
        this.mensaje = mensaje;
    }
}
