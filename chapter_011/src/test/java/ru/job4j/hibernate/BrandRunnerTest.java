package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.Brand;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * This class represents BrandRunner-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class BrandRunnerTest {

    @Test
    public void testAdd() {
        Brand body = new Brand();
        body.setId(1);
        BrandRunner.INSTANCE.addEntry(body);
        assertThat(1, is(BrandRunner.INSTANCE.getEntryById(1).getId()));
    }

/*    @Test
    public void testGetAll() {
        Brand first = new Brand();
        BrandRunner.INSTANCE.addEntry(first);
        Brand second = new Brand();
        BrandRunner.INSTANCE.addEntry(second);
        assertThat(2, is(BrandRunner.INSTANCE.getAllEntry().size()));
    }*/
}