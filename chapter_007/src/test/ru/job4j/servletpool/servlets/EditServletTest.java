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
 * This is test class for EditRoleServlet.
 * @author Svatoslav Sabirov.
 * @version 12.
 * @since 23.04.2018.
 */
public class EditServletTest {

    @Test
    public void whenEditUser() throws ServletException, IOException {
        EditServlet controller = new EditServlet();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("tea");
        when(req.getParameter("name")).thenReturn("Tasty tea");
        when(req.getParameter("email")).thenReturn("vaticorp@mail.ru");
        controller.doGet(req, resp);
        assertThat(UserStore.INSTANCE.getUser("tea").getEmail(),is("vaticorp@mail.ru"));
    }
}