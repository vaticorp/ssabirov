package ru.job4j.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is simple class for convert
 * @author Svyatoslav Sabirov.
 * @since 19.02.2018.
 * @version $id$.
 */
public class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(p -> p.getId(), t -> t));
    }
}
