package ru.job4j.sorting.quicksort;

import org.junit.Test;
import ru.job4j.sorting.insertion.Sorting;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents test-class for quick sort.
 * @author Svyatoslav Sabirov.
 * @since 17.09.2018
 * @version 12.
 */
public class QuickTest {

    @Test
    public  void whenWeTestArrayWithFiveNumbers() {
        Integer[] array = {1,9,8,3,2,6,4};
        Sorting<Integer> quick = new Quick<Integer>(array);
        quick.sort();
        assertThat(new Integer(3), is(quick.value(2)));
    }
}