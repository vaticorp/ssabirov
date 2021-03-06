package ru.job4j.ownmap;

import java.util.Objects;

/**
 * This class represents simple Calendar.
 * @author Svyatoslav Sabirov.
 * @since 08.03.2018
 * @version 7.
 */
public class Calendar {

    private int day;
    private int month;
    private int year;

    public Calendar(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Calendar)) {
            return false;
        }
        Calendar currentCalendar = (Calendar) obj;
        return currentCalendar.day == this.day
                && currentCalendar.month == this.month
                && currentCalendar.year == this.year;
    }
}
