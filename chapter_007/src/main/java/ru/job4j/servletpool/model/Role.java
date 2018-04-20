package ru.job4j.servletpool.model;

/**
 * This class represents Role-dao.
 * @author Svyatoslav Sabirov.
 * @since 20.04.2018
 * @version 1.
 */
public class Role {

    private String name;
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
