package com.maint.calc.ui.infraestructura;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EvaluadorResponse {



    private TipoRespuesta tipoRespuesta;
    private String mensaje;

    public EvaluadorResponse(TipoRespuesta tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    public EvaluadorResponse(TipoRespuesta tipoRespuesta, String mensaje) {
        this.tipoRespuesta = tipoRespuesta;
        this.mensaje = mensaje;
    }

    public enum TipoRespuesta
    {
        EXITO,
        ERROR
    }
}

