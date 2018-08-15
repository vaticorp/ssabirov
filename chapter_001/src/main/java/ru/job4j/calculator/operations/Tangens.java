package ru.job4j.calculator.operations;

import ru.job4j.calculator.Calculator;

/**
 * This class represents operation for calculator.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 9.
 */
public class Tangens implements Operation {

    private Calculator calculator;

    public Tangens(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public String getName() {
        return "tg";
    }

    @Override
    public void execute(double first, double second) {
        calculator.setResult(Math.tan(second));
    }
}
