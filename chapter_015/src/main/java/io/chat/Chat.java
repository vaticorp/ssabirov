package io.chat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class represents simple bot.
 * @author Svyatoslav Sabirov.
 * @since 02.08.2018
 * @version 7.
 */
public class Chat {

    private final String pathLog;
    private final String botCommand;
    private final List<String> botList;

    public Chat(String pathLog, String botCommand) throws IOException {
        this.botCommand = botCommand;
        this.pathLog = pathLog;
        this.botList = Files.readAllLines(Paths.get(botCommand));
    }

    public String getPathLog() {
        return pathLog;
    }

    /**
     * This method for chart with computer.
     */
    public void startDialog() {
        String command = "";
        String answer = "";
        boolean flag = true;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(this.pathLog));) {
            while (!command.equals("закончить")) {
                command = reader.readLine();
                logWriter.write(String.format("%s\r\n", command));
                flag = checkFlag(flag, command);
                if (flag) {
                    logWriter.write(String.format("%s\r\n", getRandomStringFromFile()));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkFlag(boolean flag, String word) {
        if (flag) {
            flag = (!word.equals("стоп"));
        } else  {
            flag = word.equals("продолжить");
        }
        return flag;
    }

    private String getRandomStringFromFile() {
        int random_number = 1 + (int) (Math.random() * botList.size());
        String result = botList.get(random_number);
        System.out.println(result);
        return result;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "pathLog='" + pathLog + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        new Chat("D:\\test\\log.txt","D:\\test\\bot.txt").startDialog();
    }
}
