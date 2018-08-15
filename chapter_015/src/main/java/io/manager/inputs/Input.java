package io.manager.inputs;

/**
 * This class represents base interface for input.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public interface Input {
    String ask(String question);
    int ask(String question, int size);
}
