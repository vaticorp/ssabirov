package io.manager.commands;

import io.manager.BaseSocket;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents print folder.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class PrintFolder extends BaseCommand {

    public PrintFolder(int key, String name) {
        super(key, name);
    }

    @Override
    public void executeServer(PrintWriter out, BufferedReader in, BaseSocket baseSocket) {
        StringBuilder stringBuilder = new StringBuilder();
        File baseDirectory = new File(baseSocket.getPropertyStorage().getInitialFolder());
        for (File file : baseDirectory.listFiles()) {
            stringBuilder.append(file.getAbsolutePath()).append("\n");
        }
        out.println(stringBuilder.toString());
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
