package ru.job4j.search;

import java.util.*;

/**
 * This is simple class for convert
 * @author Svyatoslav Sabirov.
 * @since 19.02.2018.
 * @version $id$.
 */
public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapOfUsers = new HashMap<Integer, User>();
        for (User user: list) {
            mapOfUsers.put(user.getId(), user);
        }
        return mapOfUsers;
    }
}
