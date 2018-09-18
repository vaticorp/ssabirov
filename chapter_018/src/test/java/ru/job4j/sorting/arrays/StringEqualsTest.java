package ru.job4j.sorting.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents test-class for StringEquals.
 * @author Svyatoslav Sabirov.
 * @since 18.09.2018
 * @version 11.
 */
public class StringEqualsTest {

    @Test
    public  void whenWeTestStringsAndFalse() {
        StringEquals stringEquals = new StringEquals("Lack","Alco");
        assertThat(false, is(stringEquals.checkEquals()));
    }

    @Test
    public  void whenWeTestStringsAndTrue() {
        StringEquals stringEquals = new StringEquals("left","felt");
        assertThat(true, is(stringEquals.checkEquals()));
    }
}