package ru.cafe.control;

/**
 * This interface represents main check command.
 * @author Svyatoslav Sabirov.
 * @since 30.11.2018
 * @version 7.
 */
public interface Check {
    void printCheck();
    double getTotalSum();
    void addCheck(Position position);
}
