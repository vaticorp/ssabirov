package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents operation for calculator.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 7.
 */
public class Subtract implements Operation {

    private Calculator calculator;

    public Subtract(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public void execute(double first, double second) {
        calculator.subtract(first, second);
    }
}
