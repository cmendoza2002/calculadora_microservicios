package com.maint.calc.ui.infraestructura;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EvaluadorRequest {
    public EvaluadorRequest(String expresion) {
        this.expresion = expresion;
    }

    private String expresion;
}
