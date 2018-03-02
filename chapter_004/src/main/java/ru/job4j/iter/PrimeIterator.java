package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {

    private int[] array;
    private int index = 0;

    public PrimeIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return getNextNumber(false) != null;
    }

    @Override
    public Object next() {
        Integer result = getNextNumber(true);
        if (result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public Integer getNextNumber(boolean moveIndex) {
        for (int i = this.index; i < array.length; i++) {
            int currentValue = array[i];
            if (currentValue <= 1) {
                continue;
            }
            double sqrtCurrent = Math.sqrt((double)currentValue);
            boolean composite = false;
            for (int j = 2; j <= sqrtCurrent; j++) {
                if (currentValue % j == 0) {
                    composite = true;
                    break;
                }
            }
            if (!composite) {
                if (moveIndex) {
                    this.index = i + 1;
                }
                return currentValue;
            }
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
