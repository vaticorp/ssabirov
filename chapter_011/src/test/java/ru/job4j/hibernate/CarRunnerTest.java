package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.Car;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * This class represents CarRunner-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class CarRunnerTest {

    @Test
    public void testAdd() {
        Car body = new Car();
        body.setId(1);
        CarRunner.INSTANCE.addEntry(body);
        assertThat(1, is(CarRunner.INSTANCE.getEntryById(1).getId()));
    }

/*    @Test
    public void testGetAll() {
        Car first = new Car();
        CarRunner.INSTANCE.addEntry(first);
        Car second = new Car();
        CarRunner.INSTANCE.addEntry(second);
        assertThat(2, is(CarRunner.INSTANCE.getAllEntry().size()));
    }*/
}