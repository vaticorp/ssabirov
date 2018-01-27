package ru.job4j.array;

/**
 * Bubble-sort.
 * @author Svyatoslav Sabirov.
 * @since 27.10.2018.
 * @version $id$.
 */
public class BubbleSort {

    /**
     * Our sorting-method.
     * @param array - array.
     * @return - sorting array.
     */
    public int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tempvalue = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tempvalue;
                }
            }
        }

        return array;
    }

}
