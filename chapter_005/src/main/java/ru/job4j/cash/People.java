package ru.job4j.cash;

/**
 * This class represents People-model.
 * @author Svyatoslav Sabirov.
 * @since 20.03.2018
 * @version 7.
 */
public class People {

    private int age;
    private String name;
    private int version;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
        this.version = 1;
    }

    public int getVersion() {
        return version;
    }

    public void updateVersion() {
        this.version++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        updateVersion();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateVersion();
    }
}
