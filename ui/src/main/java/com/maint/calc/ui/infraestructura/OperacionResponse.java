package com.maint.calc.ui.infraestructura;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperacionResponse {
    private EvaluadorResponse.TipoRespuesta tipoRespuesta;
    private String mensaje;
    private double resultado;
}
