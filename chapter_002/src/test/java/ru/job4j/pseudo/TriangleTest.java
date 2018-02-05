package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for Triangle.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 05.02.2018
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(new StringBuilder()
                         .append("    ^    ")
                         .append("   ^ ^   ")
                         .append("  ^   ^  ")
                         .append(" ^     ^ ")
                         .append("^^^^^^^^^")
                                .toString()
                )
        );
    }
}
