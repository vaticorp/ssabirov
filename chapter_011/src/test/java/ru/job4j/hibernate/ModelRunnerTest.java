package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.Model;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * This class represents ModelRunner-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class ModelRunnerTest {

    @Test
    public void testAdd() {
        Model body = new Model();
        body.setId(1);
        ModelRunner.INSTANCE.addEntry(body);
        assertThat(1, is(ModelRunner.INSTANCE.getEntryById(1).getId()));
    }

/*    @Test
    public void testGetAll() {
        Model first = new Model();
        ModelRunner.INSTANCE.addEntry(first);
        Model second = new Model();
        ModelRunner.INSTANCE.addEntry(second);
        assertThat(2, is(ModelRunner.INSTANCE.getAllEntry().size()));
    }*/
}