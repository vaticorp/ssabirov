package io.wise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents bot-class.
 * @author Svyatoslav Sabirov.
 * @since 07.08.2018
 * @version 15.
 */
public class BotServer {

    private final Socket socket;

    public BotServer(Socket socket) {
         this.socket = socket;
    }

    public void server() {
        String ask = "";
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));) {
            do {
                ask = in.readLine();
                System.out.println(ask);
                if ("hello".equals(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else {
                    System.out.println(String.format("Серверу сказали %s", ask));
                }
            } while (!("exit".equals(ask)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept();){
            BotServer botServer = new BotServer(socket);
            botServer.server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
