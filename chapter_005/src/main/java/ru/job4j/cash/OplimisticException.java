package ru.job4j.cash;

/**
 * This class represents own Exception.
 * @author Svyatoslav Sabirov.
 * @since 20.03.2018
 * @version 7.
 */
public class OplimisticException extends RuntimeException {

    public OplimisticException(String message) {
        super(message);
    }
}
