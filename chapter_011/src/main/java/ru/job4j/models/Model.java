package ru.job4j.models;

/**
 * This class represents model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class Model {

    private int id;
    private String name;

    public Model() {
    }

    public Model(int id, String name) {
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
        return "Model{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
