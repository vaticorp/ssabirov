package ru.job4j.array;

/**
 * This is class for my first task of array.
 * @author Svyatoslav Sabirov
 * @since 27.01.2017
 * @version $id$
 */

public class Square {

    /**
     * Method is calculating all numbers in array in pow 2.
     * @param bound - array length.
     * @return - array.
     */
    public int[] calculate(int bound) {

        int[] rst = new int[bound];

        // заполнить массив через цикл элементами от 1 до bound возведенные в квадрат
        for (int i = 0; i < bound; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }

        return rst;

    }
}
