package ru.cafe.exceptions;

/**
 * This class represents exception for property
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
public class PropertyNotFoundException extends RuntimeException {

    public PropertyNotFoundException(String message) {
        super(message);
    }
}
