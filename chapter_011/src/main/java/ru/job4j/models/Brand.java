package ru.job4j.models;

import java.util.List;
import java.util.Set;

/**
 * This class represents Brand-model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class Brand {

    private int id;
    private String name;
    private String description;
    Set<Model> models;

    public Brand(int id, String name, String description, Set<Model> models) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.models = models;
    }

    public Brand() {
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Brand{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
