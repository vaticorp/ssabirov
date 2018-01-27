package ru.job4j.array;

/**
 * This is class for my task of array.
 * @author Svyatoslav Sabirov
 * @since 27.01.2017
 * @version $id$
 */
public class FindLoop {

    public int indexOf(int[] data, int el) {

        int rsl = -1; // если элемента нет в массиве, то возвращаем -1.

        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rsl = index;

                break;
            }
        }

        return rsl;
    }

}
