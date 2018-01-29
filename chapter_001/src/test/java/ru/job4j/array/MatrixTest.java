package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Our test-class for Test.
 * @author Svyatoslav Sabirov
 * @since 27.01.2018
 * @version $id$.
 */
public class MatrixTest {

    @Test
    public void whenMatrixSize3to3() {

        Matrix matrix = new Matrix();
        int[][] arraymatrix = matrix.multiple(3);
        int[][] expectearray = new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(arraymatrix, is(expectearray));
    }

    @Test
    public void whenMatrixSize4to4() {

        Matrix matrix = new Matrix();
        int[][] arraymatrix = matrix.multiple(4);
        int[][] expectearray = new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertThat(arraymatrix, is(expectearray));
    }

}

