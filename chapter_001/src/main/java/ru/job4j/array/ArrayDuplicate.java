package ru.job4j.array;

import java.util.Arrays;

/**
 * This is my last class in array-packet.
 * @author Svyatoslav Sabirov.
 * @since 27.01.2018
 * @version $id$.
 */
public class ArrayDuplicate {

    public String[] remove(String[] array) {

        int curentlenght = array.length;

        for (int i = 0; i < curentlenght; i++) {
            String a = array[i];
            for (int j = i + 1; j < curentlenght;) {
                if (a.equals(array[j])) {
                    String temp = array[j];
                    array[j] = array[curentlenght - 1];
                    array[curentlenght - 1] = temp;
                    curentlenght--;
                } else {
                    j++;
                }
            }
        }
        return Arrays.copyOf(array, curentlenght);
    }
}
