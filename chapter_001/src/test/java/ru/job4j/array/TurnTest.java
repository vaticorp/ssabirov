package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Our test-class for Test.
 * @author Svyatoslav Sabirov
 * @since 27.01.2018
 * @version $id$.
 */
public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {

        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
        int[] expectearray = new int[] {4, 1, 6, 2};
        Turn turn = new Turn();
        int[] reversearray = turn.back(new int[] {2, 6, 1, 4});
        assertThat(expectearray, is(reversearray));

    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {

        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
        int[] expectearray = new int[] {5, 4, 3, 2, 1};
        Turn turn = new Turn();
        int[] reversearray = turn.back(new int[] {1, 2, 3, 4, 5});
        assertThat(expectearray, is(reversearray));
    }
}