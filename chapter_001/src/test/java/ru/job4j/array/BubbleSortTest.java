package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Our test  class for BubbleSort.
 * @author Svyatoslav Sabirov.
 * @since 27.01.2018.
 * @version $id$.
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {

        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        int[] expectearray = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        BubbleSort bubblesort = new BubbleSort();
        int[] sortarray = bubblesort.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        assertThat(expectearray, is(sortarray));

    }
}
