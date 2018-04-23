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
 * This is test class for UsersController.
 * @author Svatoslav Sabirov.
 * @version 12.
 * @since 23.04.2018.
 */
public class UsersControllerTest {

    @Test(expected = NullPointerException.class)
    public void deleteUser() throws ServletException, IOException {
        UsersController controller = new UsersController();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("login")).thenReturn("admin");
        when(req.getParameter("tea")).thenReturn("Remove");
        controller.doPost(req, resp);
        assertThat(UserStore.INSTANCE.getUser("tea").getEmail(),is("tea"));
    }
}