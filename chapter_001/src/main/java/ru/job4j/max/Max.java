package ru.job4j.max;

/**
 * This class is need for definitions of maximum value of two numbers.
 * @author Svyatoslav Sabirov
 * @since 24.01.2018 22:34
 * @version $id$
 */
public class Max {

    /**
     * Our meaning method.
     * @param first - first number.
     * @param second - second number.
     * @return maximum value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

}
