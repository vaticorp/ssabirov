package io.manager;

import io.manager.inputs.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class represents class for baseSocket.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public abstract class BaseSocket {

    private final Logger logger = LoggerFactory.getLogger(Server.class);
    protected Socket socket;
    protected final Input input;
    protected final PropertyStorage propertyStorage;
    protected PrintWriter out;
    protected BufferedReader in;

    public BaseSocket(Socket socket, Input input, PropertyStorage propertyStorage) {
        this.socket = socket;
        this.input = input;
        this.propertyStorage = propertyStorage;
    }

    public PropertyStorage getPropertyStorage() {
        return propertyStorage;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public Input getInput() {
        return input;
    }

    public abstract void connection();
}
