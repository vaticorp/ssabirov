package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents class for operation.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 7.
 */
public class Add implements Operation {

    private Calculator calculator;

    public Add(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void execute(double first, double second) {
        calculator.add(first, second);
    }

    @Override
    public String getName() {
        return "+";
    }
}
