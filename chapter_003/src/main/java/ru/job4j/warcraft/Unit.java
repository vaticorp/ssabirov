package ru.job4j.warcraft;

/**
 * This interface represents  unit-actions
 * @author Svyatoslav Sabirov.
 * @since 26.02.2018
 * @version 7.
 */
public interface Unit {
    /**
     * Улучшить своего персонажа
     */
    void updateUnit(Unit currentUnit);
    /**
     * Ослабить персонажа противника
     */
    void loosenUnit(Unit currentUnit);
    /**
     * урон атака
     */
    void attack(int damage);
    /**
     * урон атака
     */
    boolean isLive();
}