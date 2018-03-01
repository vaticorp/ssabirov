package ru.job4j.search;

import java.util.*;

/**
 * This is simple class for ConvertList.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 27.02.2018
 */
public class ConvertList {
    /**
     * This convert array to list.
     * @param array - array of Integer.
     * @return list of result.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] outherArray:array) {
            for (int number : outherArray) {
                list.add(number);
            }
        }
        return list;
    }
    /**
     * This convert list to array.
     * @param list - list.
     * @param rows - number of rows.
     * @return - array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int quotient = list.size() / rows;
        Iterator<Integer> iterator = list.iterator();
        int number = (double) list.size() / rows > quotient ? quotient + 1 : quotient;
        int[][] array = new int[rows][number];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < number; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    break;
                    //array[i][j] = 0;
                }
            }
        }
        return array;
    }

    /**
     * This is method for converting list of arrays.
     * @param list - list of integer arrrays.
     * @return - list of integer.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> convertArray = new ArrayList<Integer>();
        for (int[] current:list) {
            for (int value:current) {
                convertArray.add(value);
            }
        }
        return convertArray;
    }
}
