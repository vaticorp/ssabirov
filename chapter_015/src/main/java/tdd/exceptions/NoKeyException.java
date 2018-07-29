package tdd.exceptions;

/**
 * This class represents exception if no key in map.
 * @author Svyatoslav Sabirov.
 * @since 28.07.2018
 * @version 7.
 */
public class NoKeyException extends RuntimeException {

    public NoKeyException(String message) {
        super(message);
    }
}
