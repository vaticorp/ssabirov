package ru.job4j.models;

/**
 * This class represents Role.
 * @author Svyatoslav Sabirov.
 * @since 04.05.2018
 * @version 7.
 */
public class Role {

    private String title;
    private String description;

    public Role(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
