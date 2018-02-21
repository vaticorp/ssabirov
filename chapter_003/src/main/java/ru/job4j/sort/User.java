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

    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() >= o2.getName().length() ? 1 : -1;
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int lexikon = o1.getName().compareTo(o2.getName());
                        return lexikon == 0 ? (o1.getAge() >= o2.getAge() ? 1 : -1) : lexikon;
                    }
                }
        );
        return list;
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
