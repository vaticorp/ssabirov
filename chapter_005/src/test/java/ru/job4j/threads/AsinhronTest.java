package ru.job4j.threads;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for Asinhron.
 * @author Svatoslav Sabirov.
 * @version 12.
 * @since 15.03.2018.
 */
public class AsinhronTest {

    //private final PrintStream stdout = System.out;
    //private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        //System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        //System.setOut(this.stdout);
    }

    @Test
    public void whenTwoTreadsCalculate() {
        Asinhron testAsinhron = new Asinhron();
        testAsinhron.count("Я изучаю новый язык программирования для себя");
        //assertThat(new String(this.out.toByteArray()), is("test"));
    }
}