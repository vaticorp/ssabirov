package io.manager.commands;

/**
 * This class represents abstract-class for each command.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public abstract class BaseCommand implements Command {

    private final int key;
    private final String name;

    public BaseCommand(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
