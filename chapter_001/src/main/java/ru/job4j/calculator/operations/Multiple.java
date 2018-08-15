package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents class for calculator.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 9.
 */
public class Multiple implements Operation {

    private Calculator calculator;

    public Multiple(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return "*";
    }

    @Override
    public void execute(double first, double second) {
        calculator.multiple(first, second);
    }
}
