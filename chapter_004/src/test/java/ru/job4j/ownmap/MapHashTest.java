package ru.job4j.ownmap;

import org.junit.Test;
import java.util.*;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ListCompare.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 09.03.2018.
 */
public class MapHashTest {
    @Test
    public void whenCreateMapAndAddTwoValue() {
        MapHash<String, Integer> testMap = new MapHash<String, Integer>();
        String key = "Petr";
        testMap.insert(key, 27);
        testMap.insert("Svyatoslav", 28);
        assertThat(testMap.get(key), is(27));
    }

    @Test(expected = NoKeyException.class)
    public void whenCreateMapAndAddRemoveValue() {
        MapHash<String, Integer> testMap = new MapHash<String, Integer>();
        String key = "Petr";
        testMap.insert(key, 27);
        testMap.insert("Svyatoslav", 28);
        testMap.delete(key);
        assertThat(testMap.get(key), is(27));
    }

    @Test
    public void whenCreateMapAndAddTwoValueAndIterator() {
        MapHash<String, Integer> testMap = new MapHash<String, Integer>();
        testMap.insert("Petr", 27);
        testMap.insert("Svyatoslav", 28);
        testMap.insert("Vasya", 16);
        Iterator<MapValue<String, Integer>> testIterator = testMap.iterator();
        testIterator.next();
        testIterator.next();
        assertThat(testIterator.next().getKey(), is("Petr"));
    }
}