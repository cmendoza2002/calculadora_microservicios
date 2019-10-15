package com.maint.calc.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SpringView(name = CalculadoraView.VIEW_NAME)
public class CalculadoraView extends VerticalLayout implements View {
    public static final String VIEW_NAME= "calculadoraView";
    private double current = 0.0;
    private double stored = 0.0;
    private char lastOperationRequested = 'C';

    private final Label display = new Label("0.0");
    public void buttonClick(Button.ClickEvent event) {

        Button button = event.getButton();
        char requestedOperation = button.getCaption().charAt(0);
        double newValue = calculate(requestedOperation);
        display.setValue("" + newValue);

    }
    private double calculate(char requestedOperation) {
        if ('0' <= requestedOperation && requestedOperation <= '9') {
            current = current * 10
                    + Double.parseDouble("" + requestedOperation);
            return current;
        }
        switch (lastOperationRequested) {
            case '+':
                stored += current;
                break;
            case '-':
                stored -= current;
                break;
            case '/':
                stored /= current;
                break;
            case '*':
                stored *= current;
                break;
            case 'C':
                stored = current;
                break;
        }
        lastOperationRequested = requestedOperation;
        current = 0.0;
        if (requestedOperation == 'C') {
            stored = 0.0;
        }
        return stored;
    }


    @PostConstruct
    protected void init() {
        final GridLayout layout = new GridLayout(4, 5);
        addComponent(layout);
        layout.addComponent(display, 0, 0, 3, 0);
        String[] operations = new String[] { "7", "8", "9", "/", "4", "5", "6",
                "*", "1", "2", "3", "-", "0", "=", "C", "+" };
        for (String caption : operations) {
            Button button = new Button(caption);
            button.addClickListener(event -> buttonClick(event));
            layout.addComponent(button);
        }
    }
}
