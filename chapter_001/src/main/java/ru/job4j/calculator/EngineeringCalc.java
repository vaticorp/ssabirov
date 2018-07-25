package ru.job4j.calculator;

import java.util.Collections;

/**
 * This class represents class for engineering calculator.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 7.
 */
public class EngineeringCalc extends InteractCalc {

    public EngineeringCalc(Calculator calculator) {
        super(calculator);
        Collections.addAll(validOperations, "cos","sin","tg");
    }

    @Override
    public void execute(String query, double secondValue) {
        super.execute(query, secondValue);
        if (query.equals("cos")) {
            calculator.setResult(Math.cos(calculator.getResult()));
        } else if (query.equals("sin")) {
            calculator.setResult(Math.sin(calculator.getResult()));
        } else if (query.equals("tg")) {
            calculator.setResult(Math.tan(calculator.getResult()));
        }
    }

    public static void main(String[] args) {
        InteractCalc interactCalc = new EngineeringCalc(new Calculator());
        interactCalc.start();
    }
}
