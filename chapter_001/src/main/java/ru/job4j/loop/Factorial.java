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

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}
