package ru.job4j.ownmap;

/**
 * This class represents User-model.
 * @author Svyatoslav Sabirov.
 * @since 08.03.2018
 * @version 7.
 */
public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
