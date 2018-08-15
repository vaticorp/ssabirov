package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents sinus.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 9.
 */
public class Sinus implements Operation {

    private Calculator calculator;

    public Sinus(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return "sin";
    }

    @Override
    public void execute(double first, double second) {
        calculator.setResult(Math.sin(second));
    }
}
