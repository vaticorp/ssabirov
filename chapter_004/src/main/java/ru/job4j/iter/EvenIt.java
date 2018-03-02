package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents iterator for event numbers.
 * @author Svyatoslav Sabirov.
 * @since 01.03.2018
 * @version 7.
 */
public class EvenIt implements Iterator {

    private int[] array;
    private int index = 0;

    public EvenIt(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return getNextEvent(false) != null;
    }

    private Integer getNextEvent(boolean moveIndex) {
        Integer result = null;
        for (int i = this.index; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result = array[i];
                if (moveIndex) {
                    this.index = i + 1;
                }
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        Integer result = getNextEvent(true);
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
