package ru.job4j.sorting.insertion;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents Test-class for Insertion.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 9.
 */
public class InsertionTest {

    @Test
    public  void whenWeTestArrayWithFiveNumbers() {
        Integer[] array = {1,9,8,3,2,6,4};
        Sorting<Integer> insertion = new Insertion<Integer>(array);
        insertion.sort();
        assertThat(new Integer(3), is(insertion.value(2)));
    }
}