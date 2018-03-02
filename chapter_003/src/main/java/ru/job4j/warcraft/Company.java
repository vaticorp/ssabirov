package ru.job4j.warcraft;


import java.util.ArrayList;
import java.util.List;

/**
 * This class represents Company
 * @author Svyatoslav Sabirov.
 * @since 26.02.2018
 * @version 11.
 */
public class Company {

    private List<Initial> composition = new ArrayList<Initial>();

    public void addUnit(Initial soldier) {
        composition.add(soldier);
    }

    public boolean companyAlive() {
        return composition.size() != 0;
    }
}
