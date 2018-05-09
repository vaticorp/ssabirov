package ru.job4j.repository;

/**
 * This class represents common realisation
 * @author Svyatoslav Sabirov.
 * @since 07.05.2018
 * @version 7.
 */
public interface CommonSpecification<T> {
    boolean specified(T value);
    public String toSqlClauses();
}
