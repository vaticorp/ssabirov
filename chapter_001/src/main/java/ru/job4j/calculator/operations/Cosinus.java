package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents operation.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 7.
 */
public class Cosinus implements Operation {

    private Calculator calculator;

    public Cosinus(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return "cos";
    }

    @Override
    public void execute(double first, double second) {
        calculator.setResult(Math.cos(second));
    }
}

