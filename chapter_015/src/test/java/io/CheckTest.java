package io;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * This class represents class for testing.
 * @author Svyatoslav Sabirov.
 * @since 01.08.2018
 * @version 12.
 */
public class CheckTest {

    @Test
    public void whenWeCheckEvenNumber() {
        Check check = new Check();
        assertThat(true, is(check.isNumber(System.in)));
    }

    @Test
    public void whenWeCheckOddNumber() {
        Check check = new Check();
        assertThat(false, is(check.isNumber(System.in)));
    }
}