package ru.job4j.hibernate;

import java.util.List;

/**
 * This class represents common interface for Models.
 * @author Svyatoslav Sabirov.
 * @since 23.05.2018
 * @version 7.
 */
public interface CommonHibernate<T> {
    public List<T> getAllEntry();
    public T getEntryById(int id);
}
