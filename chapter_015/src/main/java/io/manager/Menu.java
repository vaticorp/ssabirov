package io.manager;

import io.manager.commands.*;
import io.manager.inputs.Input;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class represents class for client-menu.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 9.
 */
public class Menu {

    private final boolean isServer;
    private ArrayList<Command> commands = new ArrayList<Command>();
    private int exitCommand;

    public Menu(boolean isServer, int exitCommand) {
        this.isServer = isServer;
        this.exitCommand = exitCommand;
    }

    public int getExitCommand() {
        return exitCommand;
    }

    public void setExitCommand(int exitCommand) {
        this.exitCommand = exitCommand;
    }

    public int size() {
        return commands.size();
    }

    public void createMenu() {
        commands.add(new Up(0, "Перейти выше"));
        commands.add(new Down(1, "Перейти в подкаталог"));
        commands.add(new PrintFolder(2, "Вывести содержимое каталога"));
        commands.add(new Download(3, "Скачать файл"));
        commands.add(new Upload(4, "Загрузить файл"));
        commands.add(new Exit(5, "Завершить работу"));
    }

    public void select(int key, PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        if (isServer) {
            this.commands.get(key).executeServer(out, in, baseSocket);
        } else {
            this.commands.get(key).executeClient(out, in, baseSocket);
        }

    }

    public void showMenu() {
        commands.forEach(s -> System.out.println(s.info()));
    }
}
