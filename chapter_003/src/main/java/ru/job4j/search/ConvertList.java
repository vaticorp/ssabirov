package ru.job4j.search;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Integer> result = Arrays.stream(array)
                .flatMapToInt(i -> Arrays.stream(i)).boxed().collect(Collectors.toList());
        return result;
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
                if (!iterator.hasNext()) {
                    break;
                }
                array[i][j] = iterator.next();
            }
        }
        return array;
    }

    /**
     * This is method for converting list of arrays.
     * @param values - list of integer arrrays.
     * @return - list of integer.
     */
    public List<Integer> convert(List<int[]> values) {
        List<Integer> convertArray = new ArrayList<Integer>();
        values.stream().forEach(current -> {convertArray.addAll(Arrays.stream(current).boxed().collect(Collectors.toList()));});
        return convertArray;
    }
}
