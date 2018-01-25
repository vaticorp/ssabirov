package ru.job4j.max;

/**
 * This class is need for definitions of maximum value of two numbers.
 * @author Svyatoslav Sabirov
 * @since 24.01.2018 22:34
 * @version $id$
 */
public class Max {

    /**
     * Maximum of two numbers.
     * @param first - first number.
     * @param second - second number.
     * @return maximum value.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Maximum of three numbers.
     * @param first - first number.
     * @param second - second number.
     * @param third - third number.
     * @return maximum value.
     */
    public int max(int first, int second, int third) {
       return max(max(first, second), third);
    }

}
