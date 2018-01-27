package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for Square.
 * @author Svyatoslav Sabirov
 * @since 27.01.2017
 * @version $id$
 */
public class SquareTest {

    @Test
    public void whenArrayLenght5() {

        Square square = new Square();
        int[] expectedarray = new int[] {1, 4, 9, 16, 25};
        int[] testarray = square.calculate(5);
        assertThat(testarray, is(expectedarray));
    }

    @Test
    public void whenArrayLenght7() {

        Square square = new Square();
        int[] expectedarray = new int[] {1, 4, 9, 16, 25, 36, 49};
        int[] testarray = square.calculate(7);
        assertThat(testarray, is(expectedarray));
    }

}
