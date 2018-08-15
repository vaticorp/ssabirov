package io.manager.commands;

import io.manager.BaseSocket;
import io.manager.PropertyStorage;
import io.manager.inputs.Input;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * This class represents command for exit.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class Exit extends BaseCommand {

    public Exit(int key, String name) {
        super(key, name);
    }

    @Override
    public void executeServer(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        System.out.println("Выход из программы");
    }

    @Override
    public void executeClient(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        System.out.println("Выход из программы");
    }
}
