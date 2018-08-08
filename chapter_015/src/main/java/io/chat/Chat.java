package io.chat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class represents simple bot.
 * @author Svyatoslav Sabirov.
 * @since 02.08.2018
 * @version 7.
 */
public class Chat {

    private String pathLog;
    private String botCommand;

    public Chat(String pathLog, String botCommand) {
        this.pathLog = pathLog;
        this.botCommand = botCommand;
    }

    public String getPathLog() {
        return pathLog;
    }

    public void setPathLog(String pathLog) {
        this.pathLog = pathLog;
    }

    public String getBotCommand() {
        return botCommand;
    }

    public void setBotCommand(String botCommand) {
        this.botCommand = botCommand;
    }

    /**
     * This method for chart with computer.
     */
    public void startDialog() {
        String command = "";
        String answer = "";
        boolean flag = true;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(this.pathLog));
            RandomAccessFile f = new RandomAccessFile(this.botCommand, "r");) {
            while (!command.equals("закончить")) {
                command = reader.readLine();
                logWriter.write(String.format("%s\r\n", command));
                flag = checkFlag(flag, command);
                if (flag) {
                    logWriter.write(String.format("%s\r\n", getStringFromFile(f)));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean checkFlag(boolean flag, String word) {
        if (flag == true) {
            flag = (!word.equals("стоп"));
        } else  {
            flag = word.equals("продолжить");
        }
        return flag;
    }

    private String getStringFromFile(RandomAccessFile f) throws IOException {
        String answer = "";
        long randomLocation = (long) (Math.random() * f.length());
        f.seek(randomLocation);
        answer = f.readLine();
        String s_L = "";
        char a_char = Character.MIN_VALUE;
        long leftLocation = randomLocation;
        while (a_char != '\n' && a_char != '\r' && a_char != -1) {
            a_char = (char)f.readByte();
            s_L = a_char + s_L;
            leftLocation--;
            f.seek(leftLocation);
        }
        String s_R = "";
        a_char = Character.MIN_VALUE;
        while (a_char != '\n' && a_char != '\r' && a_char != -1) {
            a_char = (char)f.readByte();
            s_R = s_R + a_char;
            randomLocation++;
            f.seek(randomLocation);
        }
        System.out.println(String.format("%s%s%s", s_L, answer, s_R));
        return String.format("%s%s%s", s_L, answer, s_R);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "pathLog='" + pathLog + '\'' +
                ", botCommand='" + botCommand + '\'' +
                '}';
    }

    public static void main(String[] args) {
        new Chat("D:\\test\\log.txt","D:\\test\\bot.txt").startDialog();
    }
}
