package ru.job4j.dao;

import ru.job4j.models.Role;

import java.util.List;

/**
 * This class represents dao-operation for Role
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 7.
 */
public interface CommonDao<T> {

    public boolean create(T value);
    public List<T> selectAll();
    public T select(String id);
    public boolean edit(T value);
    public boolean remove(String id);
}
