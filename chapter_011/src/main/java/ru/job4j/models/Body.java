package ru.job4j.models;

/**
 * This class represents body-model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class Body {

    private int id;
    private String name;

    public Body() {
    }

    public Body(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Body{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
