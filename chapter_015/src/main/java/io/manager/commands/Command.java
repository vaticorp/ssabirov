package io.manager.commands;

import io.manager.BaseSocket;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * This class represents interface for commands.
 * @author Svyatoslav Sabirov.
 * @since 09.08.2018
 * @version 7.
 */
public interface Command {
    void executeServer(PrintWriter out, BufferedReader in, BaseSocket baseSocket);
    void executeClient(PrintWriter out, BufferedReader in, BaseSocket baseSocket);
    int key();
    String info();
}
