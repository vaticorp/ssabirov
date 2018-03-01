package ru.job4j.iter;

import java.util.Iterator;

/**
 * This class represents own iterator.
 * @author Svyatoslav Sabirov.
 * @since 01.03.2018
 * @version 7.
 */
public class ArrayIterator implements Iterator {

    private int[][] array;
    private int outerIndex = 0;
    private int innerIndex = 0;

    public ArrayIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return outerIndex != array.length - 1 || innerIndex != array[outerIndex].length;
    }

    @Override
    public Integer next() {
        if (innerIndex >= array[outerIndex].length) {
            innerIndex = 0;
            outerIndex++;
        }
        return array[outerIndex][innerIndex++];
    }
}
