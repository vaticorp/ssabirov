package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for ArrayDuplicate.
 * @author Svyatoslav Sabirov.
 * @since 27.01.2018.
 * @version $id$.
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {

        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] uniqarray = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expectedarray = new String[]{"Привет", "Мир", "Супер"};
        assertThat(uniqarray, is(expectedarray));

    }
}
