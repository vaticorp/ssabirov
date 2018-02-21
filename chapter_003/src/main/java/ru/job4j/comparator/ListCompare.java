package ru.job4j.comparator;

import java.util.*;

/**
 * Реализация компаратора для списка.
 * @author Svyatoslav Sabirov.
 * @since 21.02.2018.
 * @version $id$.
 */
public class ListCompare implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
        int index = 0;
        while ((index != left.size()) && (index != right.size())) {
            if (left.get(index) != right.get(index)) {
                result = left.get(index) >= right.get(index) ? 1 : -1;
                break;
            }
            index++;
        }
        if (index != left.size()) {
            result = 1;
        } else if (index != right.size()) {
            result = -1;
        }
        return result;
    }
}
