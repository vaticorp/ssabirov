package ru.job4j.sorting.arrays;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UniqueTest {

    @Test
    public  void whenWeTestArrayWithEightNumbersAndFalse() {
        Character[] array = {'d','s','f','s','r','e','w','q'};
        Unique unique = new Unique(array);
        assertThat(false, is(unique.checkUnique()));
    }

    @Test
    public  void whenWeTestArrayWithEightNumbersAndTrue() {
        Character[] array = {'d','s','f','z','r','e','w','q'};
        Unique unique = new Unique(array);
        assertThat(true, is(unique.checkUnique()));
    }

}