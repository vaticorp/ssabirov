package io.manager;

import io.manager.inputs.ConsoleInput;
import io.manager.inputs.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class represents class for server-api.
 * @author Svyatoslav Sabirov.
 * @since 09.08.2018
 * @version 7.
 */
public class Server extends BaseSocket {

    private final Logger logger = LoggerFactory.getLogger(Server.class);
    private Menu menu;

    public Server(Socket socket, Input input, Menu menu, PropertyStorage propertyStorage) {
        super(socket, input, propertyStorage);
        this.menu = menu;
    }

    @Override
    public void connection() {
        String ask = "";
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));) {
            String exit = String.valueOf(menu.getExitCommand());
            do {
                ask = in.readLine();
                menu.select(Integer.parseInt(ask), out, in, this);
            } while (!(exit.equals(ask)) && socket.isClosed() == false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PropertyStorage property = new PropertyStorage();
        try (Socket socket = new ServerSocket(property.getPort()).accept();) {
            Input input = new ConsoleInput();
            Menu menu = new Menu(true, 5);
            menu.createMenu();
            Server server = new Server(socket, input, menu, property);
            server.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
