package ru.job4j.owntree;

/**
 * This class represents exception for Node.
 * @author Svyatoslav Sabirov.
 * @since 10.03.2018
 * @version 7.
 */
public class NoSuchNodeException extends RuntimeException {
    public NoSuchNodeException(String message) {
        super(message);
    }
}
