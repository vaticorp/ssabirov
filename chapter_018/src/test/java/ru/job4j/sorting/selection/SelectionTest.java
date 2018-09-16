package ru.job4j.sorting.selection;

import org.junit.Test;
import ru.job4j.sorting.insertion.Sorting;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents test-class for Selection.
 * @author Svyatoslav Sabirov.
 * @since 16.09.2018
 * @version 11.
 */
public class SelectionTest {

    @Test
    public void whenWeCreateArrayWithSixNumbersAndGetThird() {
        Integer[] array = {1,9,8,3,2,6,4};
        Sorting<Integer> selection = new Selection<>(array);
        selection.sort();
        assertThat(new Integer(3), is(selection.value(2)));
    }
}