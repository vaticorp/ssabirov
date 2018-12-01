package ru.cafe.control;

import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents class for open shift.
 * we will use a wrapper for each Beverage.
 * @author Svyatoslav Sabirov.
 * @since 30.11.2018
 * @version 7.
 */
@Setter
@Getter
@ToString
public class Shift {

    private String name;
    private final Date start;
    private Date end;
    List<Check> checkList = new ArrayList<Check>();

    public Shift(final String name) {
        this.name = name;
        this.start = new Date();
    }

    public void addCheck(final Check check) {
        this.checkList.add(check);
    }
}
