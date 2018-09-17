package ru.job4j.sorting.arrays;

import java.util.stream.Stream;

/**
 * This class represents Unique-array.
 * @author Svyatoslav Sabirov.
 * @since 17.09.2018
 * @version 7.
 */
public class Unique  {

    private final Character[] chars;

    public Unique(Character[] chars) {
        this.chars = chars;
    }

    boolean checkUnique() {
        return Stream.of(chars).distinct().count() == chars.length;
    }
}
