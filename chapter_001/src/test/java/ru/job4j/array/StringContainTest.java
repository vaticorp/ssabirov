package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test-class for StringContain.
 * @author Svyatoslav Sabirov.
 * @since 29.01.2018.
 * @version $id$.
 */
public class StringContainTest {

    @Test
     public void whenResultIsTrue() {

         StringContain stringContain = new StringContain();
         boolean result = stringContain.contains("Привет", "иве");
         assertThat(result, is(true));

     }

}
