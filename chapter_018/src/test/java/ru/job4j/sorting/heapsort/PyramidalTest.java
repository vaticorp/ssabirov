package ru.job4j.sorting.heapsort;

import org.junit.Test;
import ru.job4j.sorting.insertion.Sorting;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents test-class for pyramidal.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 11.
 */
public class PyramidalTest {

    @Test
    public  void whenWeTestArrayWithFiveNumbers() {
        Integer[] array = {1,9,8,3,2,6,4};
        Sorting<Integer> pyramidal = new Pyramidal<Integer>(array);
        pyramidal.sort();
        assertThat(new Integer(3), is(pyramidal.value(2)));
    }
}