package ru.job4j.servletpool.servlets;

import org.junit.Test;
import ru.job4j.servletpool.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This is test class for CreateServlet.
 * @author Svatoslav Sabirov.
 * @version 12.
 * @since 23.04.2018.
 */
public class CreateServletTest {

    @Test
    public void whenCreateNewUser() throws ServletException, IOException {
        CreateServlet controller = new CreateServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("login")).thenReturn("tea1");
        when(req.getParameter("name")).thenReturn("tea1");
        when(req.getParameter("email")).thenReturn("email1");
        when(req.getParameter("password")).thenReturn("123");
        when(req.getParameter("role")).thenReturn("guest");
        controller.doPost(req, resp);
        assertThat(UserStore.INSTANCE.getUser("tea1").getEmail(),is("email1"));
    }
}