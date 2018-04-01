package ru.job4j.db;

/**
 * This class represents PostgresException.
 * @author Svyatoslav Sabirov.
 * @since 01.04.2018
 * @version 7.
 */
public class PostgresException extends RuntimeException {

    public PostgresException(String message) {
        super(message);
    }
}
