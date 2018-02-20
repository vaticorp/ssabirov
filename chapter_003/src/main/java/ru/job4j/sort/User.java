package ru.job4j.sort;

import java.util.*;

/**
 * This is simple example of sorting class.
 * @author Svyatoslav Sabirov.
 * @since 20.02.2018.
 * @version $id$.
 */
public class User implements Comparable<User> {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.age >= o.age ? 1 : -1;
    }
    public Set<User> sort(List<User> list) {
       Set<User> userSet = new TreeSet<User>();
       userSet.addAll(list);
       return userSet;
    }
}
