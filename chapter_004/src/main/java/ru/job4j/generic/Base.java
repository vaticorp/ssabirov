package ru.job4j.generic;

/**
 * This class represents abstract class Base.
 * @author Svyatoslav Sabirov.
 * @since 04.03.2018
 * @version 7.
 */
public abstract class Base {

    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
