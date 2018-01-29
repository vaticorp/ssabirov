package ru.job4j.array;

/**
 * This is our matrix-class.
 * @author Svyatoslav Sabirov.
 * @since 27.01.2018
 * @version $id$.
 */
public class Matrix {

    int[][] multiple(int size) {

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }

        return matrix;
    }
}
