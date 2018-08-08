package io.wise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class represents bot-class.
 * @author Svyatoslav Sabirov.
 * @since 07.08.2018
 * @version 15.
 */
public class BotClient {

    private final Socket socket;

    public BotClient(Socket socket) {
        this.socket = socket;
    }

    public void client() {
        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);) {
            String message = "";
            String answer = "";
            do {
                out.println("Hello oracle");
                message = console.nextLine();
                out.println(message);
                if (("hello".equals(message))) {
                    while (!(answer = in.readLine()).isEmpty()) {
                        System.out.println(answer);
                    }
                }
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), 5000)){
            BotClient botClient = new BotClient(socket);
            botClient.client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
