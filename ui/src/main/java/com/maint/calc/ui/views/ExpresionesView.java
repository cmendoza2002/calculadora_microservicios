package com.maint.calc.ui.views;

import com.maint.calc.ui.servicios.EvaluadorService;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView(name = ExpresionesView.VIEW_NAME)
public class ExpresionesView extends VerticalLayout implements View {
    public static final String VIEW_NAME= "expresionesView";
    @Autowired
    EvaluadorService service;
    TextField textField = new TextField("Ingrese la expresion: ");
    Label result = new Label("Resultado");
    Button boton = new Button(() -> {
        result.setValue("" + service.procesar(textField.getValue()));
        return null;
    });

    public ExpresionesView()
    {
        addComponents(textField,boton);
    }

}
