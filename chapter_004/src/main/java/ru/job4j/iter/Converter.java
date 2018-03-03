package ru.job4j.iter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * This class represents Converter.
 * @author Svyatoslav Sabirov.
 * @since 02.03.2018
 * @version 9.
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> innerIterator = initInnerIterator();

            @Override
            public void forEachRemaining(Consumer<? super Integer> action) {
                throw new UnsupportedOperationException();
            }

            public Iterator<Integer> initInnerIterator() {
                Iterator<Integer> currentIterator = (new ArrayList<Integer>()).iterator();
                while (it.hasNext()) {
                    currentIterator = it.next();
                    if (currentIterator.hasNext()) {
                        break;
                    }
                }
                return currentIterator;
            }

            @Override
            public boolean hasNext() {
                return innerIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Integer result = innerIterator.next();
                if (!innerIterator.hasNext() && it.hasNext()) {
                    this.innerIterator = initInnerIterator();
                }
                return result;
            }
        };
    }
}

