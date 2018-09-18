package ru.job4j.sorting.arrays;

import java.util.Arrays;

/**
 * This class represents class for string-compare.
 * @author Svyatoslav Sabirov.
 * @since 18.09.2018
 * @version 7.
 */
public class StringEquals {

    private String firstString;
    private String secondString;

    public StringEquals(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public boolean checkEquals() {
        char[] firstChar = firstString.toCharArray();
        char[] secondChar = secondString.toCharArray();
        Arrays.sort(firstChar);
        Arrays.sort(secondChar);
        return Arrays.equals(firstChar, secondChar);
    }
}
