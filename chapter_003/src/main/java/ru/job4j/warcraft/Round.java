package ru.job4j.warcraft;

/**
 * This class represents single round.
 * @author Svyatoslav Sabirov.
 * @since 26.02.2018
 * @version 7.
 */
public class Round {

    public void start() {
        Company darkSide = new Company();
        darkSide.addUnit(new Initial());
        Company brightSide = new Company();
    }
}
