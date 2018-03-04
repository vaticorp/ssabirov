package ru.job4j.generic;

/**
 * This class represents Store.
 * @author Svyatoslav Sabirov.
 * @since 04.03.2018
 * @version 7.
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
