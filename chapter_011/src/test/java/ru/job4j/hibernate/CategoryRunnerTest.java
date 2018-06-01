package ru.job4j.hibernate;

import org.junit.Test;
import ru.job4j.models.Category;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * This class represents CategoryRunner-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class CategoryRunnerTest {

    @Test
    public void testAdd() {
        Category body = new Category();
        body.setId(1);
        CategoryRunner.INSTANCE.addEntry(body);
        assertThat(1, is(CategoryRunner.INSTANCE.getEntryById(1).getId()));
    }

    @Test
    public void testGetAll() {
        Category first = new Category();
        CategoryRunner.INSTANCE.addEntry(first);
        Category second = new Category();
        CategoryRunner.INSTANCE.addEntry(second);
        assertThat(2, is(CategoryRunner.INSTANCE.getAllEntry().size()));
    }
}