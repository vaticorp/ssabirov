package ru.job4j.warcraft;

/**
 * This class represents simple Soldier.
 * @author Svyatoslav Sabirov.
 * @since 26.02.2018
 * @version 6.
 */
public class Initial implements Unit, Comparable {

    private boolean improved = false;
    private boolean cursed = false;
    private int health = 100;

    @Override
    public void updateUnit(Unit currentUnit) {

    }

    @Override
    public void loosenUnit(Unit currentUnit) {

    }

    @Override
    public void attack(int damage) {
        this.health -= damage;
    }

    @Override
    public boolean isLive() {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        //return this.improved == true ? 1 : -1;
        return 1;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    public void setImproved(boolean improved) {
        this.improved = improved;
    }
}
