package io.manager.commands;

import io.manager.BaseSocket;
import io.manager.PropertyStorage;
import io.manager.inputs.Input;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents command for up.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class Up extends BaseCommand {

    public Up(int key, String name) {
        super(key, name);
    }

    @Override
    public void executeServer(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        StringBuilder stringBuilder = new StringBuilder();
        File baseDirectory = new File(baseSocket.getPropertyStorage().getInitialFolder());
        stringBuilder.append(baseDirectory.getParent());
        baseSocket.getPropertyStorage().setInitialFolder(stringBuilder.toString());
        out.println(String.format("Переход в родительский каталог %s", stringBuilder.append("\n").toString()));

    }

    @Override
    public void executeClient(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        String answer = "";
        try {
            while (!(answer = in.readLine()).isEmpty()) {
                System.out.println(answer);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
