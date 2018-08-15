package io.manager;

import io.manager.inputs.ConsoleInput;
import io.manager.inputs.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * This class represents class for client.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class Client extends BaseSocket {

    private final Logger logger = LoggerFactory.getLogger(Server.class);
    private Menu menu;

    public Client(Socket socket, Input input, Menu menu, PropertyStorage propertyStorage) {
        super(socket, input, propertyStorage);
        this.menu = menu;
    }

    @Override
    public void connection() {
        try(PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            int point;
            String answer = "";
            int exit = menu.getExitCommand();
            do {
                menu.showMenu();
                point = input.ask("Введите команду: " , menu.size());
                out.println(point);
                menu.select(point, out, in, this);
            } while (point != exit && socket.isClosed() == false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PropertyStorage property = new PropertyStorage();
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), property.getPort())) {
            Input input = new ConsoleInput();
            Menu menu = new Menu(false, 5);
            menu.createMenu();
            Client client = new Client(socket, input , menu, property);
            client.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
/*    File file = new File("D:\\test\\rom");
        System.out.println(file.getParent());*/
    }
}
