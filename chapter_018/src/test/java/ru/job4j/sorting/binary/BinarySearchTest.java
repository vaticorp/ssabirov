package ru.job4j.sorting.binary;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents BinarySearch test-class.
 * @author Svyatoslav Sabirov.
 * @since 17.09.2018
 * @version 11.
 */
public class BinarySearchTest {

    @Test
    public  void whenWeTestArrayWithFiveNumbers() {
        Integer[] array = {1,2,3,4,5,6,7,8};
        BinarySearch<Integer> binarySearch = new BinarySearch<Integer>(array);
        assertThat(3, is(binarySearch.findIndex(4)));
    }

    @Test
    public  void whenWeTestArrayWithFiveNumbersAndNotFound() {
        Integer[] array = {1,2,3,4,5,6,7,8};
        BinarySearch<Integer> binarySearch = new BinarySearch<Integer>(array);
        assertThat(-1, is(binarySearch.findIndex(-5)));
    }

}