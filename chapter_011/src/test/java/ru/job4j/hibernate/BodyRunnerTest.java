package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.Body;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents Body-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class BodyRunnerTest {

    @Test
    public void testAdd() {
        Body body = new Body();
        body.setId(1);
        BodyRunner.INSTANCE.addEntry(body);
        assertThat(1, is(BodyRunner.INSTANCE.getEntryById(1).getId()));
    }

    @Test
    public void testGetAll() {
        Body first = new Body();
        BodyRunner.INSTANCE.addEntry(first);
        Body second = new Body();
        BodyRunner.INSTANCE.addEntry(second);
        assertThat(2, is(BodyRunner.INSTANCE.getAllEntry().size()));
    }
}