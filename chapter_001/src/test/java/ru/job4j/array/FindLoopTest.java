package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for FindLoop.
 * @author Svyatoslav Sabirov
 * @since 27.01.2017
 * @version $id$
 */
public class FindLoopTest {

    @Test
    public void whenResultIsSuccesse() {

        FindLoop findLoop  = new FindLoop();
        int[] arrayforfind = new int[] {1, 34, 2, 7, 15, 89, 11, 3};
        int index = findLoop.indexOf(arrayforfind, 7);
        assertThat(3, is(index));

    }

    @Test
    public void whenResultIsFail() {

        FindLoop findLoop  = new FindLoop();
        int[] arrayforfind = new int[] {1, 34, 2, 7, 15, 89, 11, 3};
        int index = findLoop.indexOf(arrayforfind, 55);
        assertThat(-1, is(index));

    }

}
