package ru.job4j.loop;

/**
 * This class is calculating factorial on easy way(without using BigInteger)
 * @author Svyatoslav Sabirov
 * @since 25.01.2018
 * @version $id$.
 */
public class Factorial {

    /**
     * Our main method.
     * @param n - value.
     * @return - result.
     */
    public int calc(int n) {

        int result = 1;

        while (n > 0) {
            result *= n;
            n--;
        }

        return result;
    }
}
