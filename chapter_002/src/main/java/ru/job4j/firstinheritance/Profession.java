package ru.job4j.firstinheritance;

/**
 * My first base-class.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 31.01.2018.
 */
public class Profession {

    /**
     * Constructor.
     * @param diploma - exist.
     * @param age - years.
     * @param name - full name.
     */
    public Profession(boolean diploma, int age, String name) {
        this.diploma = diploma;
        this.age = age;
        this.name = name;
    }

    private boolean diploma;
    private int age;
    private String name;

    public boolean isDiploma() {
        return diploma;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
