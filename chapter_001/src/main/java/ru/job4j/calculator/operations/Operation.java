package ru.job4j.calculator.operations;

/**
 * This class represents interface for calculations operations.
 * @author Svyatoslav Sabirov.
 * @since 15.08.2018
 * @version 7.
 */
public interface Operation {
    String getName();
    void execute(double first, double second);
}
