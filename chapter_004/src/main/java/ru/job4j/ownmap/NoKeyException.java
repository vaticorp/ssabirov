package ru.job4j.ownmap;

/**
 * This class represents own Exception
 * @author Svyatoslav Sabirov.
 * @since 09.03.2018
 * @version 7.
 */
public class NoKeyException extends RuntimeException {

    public NoKeyException(String message) {
        super(message);
    }
}
