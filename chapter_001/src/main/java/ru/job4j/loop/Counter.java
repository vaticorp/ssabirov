package ru.job4j.loop;

/**
 * This my first loop-class on java.
 * @author Svyatoslav Sabirov
 * @since 25.01.2018
 * @version $id$
 */
public class Counter {

    /**
     * Method summrize even numbers.
     * @param start - start number.
     * @param finish - finish number.
     * @return result number.
     */
    public int add(int start, int finish) {

        int result = 0;

        for (int i = start; i < finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }

        return result;
    }

}
