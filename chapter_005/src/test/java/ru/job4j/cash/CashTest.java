package ru.job4j.cash;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ListCompare.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 20.03.2018.
 */
public class CashTest {
    @Test(expected = OplimisticException.class)
    public void whenAddThoPeople() {
        Cash testCash = new Cash();
        People petr = new People(15, "Petr");
        People glor = new People(12, "Glor");
        testCash.add(glor);
        testCash.add(petr);
        petr.setName("Petro");
        testCash.update(petr, "Ivan");
        //testCash.delete(petr);
    }
}