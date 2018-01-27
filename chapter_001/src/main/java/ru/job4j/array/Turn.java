package ru.job4j.array;

/**
 * This class turn our array.
 * @author Svyatoslav Sabirov
 * @since 27.10.2017
 * @version $id$.
 */

public class Turn {

    /**
     * Our method which reverse array;
     * @param array - array;
     * @return - reverse array;
     */
    public int[] back(int[] array) {

        for (int i=0; i < array.length/2; i++) {

            int tempvalue = array[array.length-1-i];
            array[array.length-1-i] = array[i];
            array[i] = tempvalue;

        }
        return array;
    }
}
