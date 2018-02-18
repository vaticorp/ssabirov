package ru.job4j.search;

/**
 * This is test-class for PhoneDictionaryTest.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 18.02.2018
 */
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void whenListToArray() {
        ConvertList convertation = new ConvertList();
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(list, is(convertation.toList(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
    @Test
    public void whenArrayListToList() {
        ConvertList convertation = new ConvertList();
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7);
        assertThat(array, is(convertation.toArray(list, 3)));
    }
}

