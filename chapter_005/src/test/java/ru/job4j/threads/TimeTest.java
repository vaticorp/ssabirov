package ru.job4j.threads;

import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for Time.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 15.03.2018.
 */
public class TimeTest {
    @Test
    public void whenOneThreadInterruptAnother() {
        //Начинаем считать текст
        Thread textThread = new Thread(new CountChar());
        textThread.start();
        //включаем таймаут
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.add(Calendar.SECOND, 10);
        Thread timeThread = new Thread(new Time(currentCalendar.getTime()));
        timeThread.start();
        try {

            timeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textThread.interrupt();
    }
}