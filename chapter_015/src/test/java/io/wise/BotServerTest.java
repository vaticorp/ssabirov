package io.wise;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class represents test-class for BotServer.
 * @author Svyatoslav Sabirov.
 * @since 08.08.2018
 * @version 11.
 */
public class BotServerTest {

    private static final String separator = System.getProperty("line.separator");

    @Test
    public void whenWeSendExitMessageThenExit() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("exit".getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        BotServer botServer = new BotServer(socket);
        botServer.server();
        assertThat(out.toString(), is(""));
    }

    @Test
    public void whenWeSendHiMessageThenHi() throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(String.format("hello%sexit",separator).getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        BotServer botServer = new BotServer(socket);
        botServer.server();
        assertThat(out.toString(), is(String.format("Hello, dear friend, I'm a oracle.%s%s",separator, separator)));
    }
}