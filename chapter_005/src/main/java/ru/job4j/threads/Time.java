package ru.job4j.threads;

import java.util.Calendar;
import java.util.Date;

/**
 * This class represents Time.
 * @author Svyatoslav Sabirov.
 * @since 15.03.2018
 * @version 7.
 */
public class Time implements Runnable {

    private Date stopDate;

    public Time(Date stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public void run() {
        while (new Date().before(stopDate)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
