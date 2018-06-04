package ru.job4j.todolist.hibernate;

import ru.job4j.todolist.model.Item;

import java.util.List;

/**
 * This class represents dao-operation
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 7.
 */
public interface HibernateDao<T> {
    public void addEntity(T value);
    public List<T> getAllEnties();
}

