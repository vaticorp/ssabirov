package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;
import ru.job4j.servletpool.model.Role;
import ru.job4j.servletpool.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class represents servlet for create users.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", UserStore.INSTANCE.getRoles());
        req.setAttribute("countries", UserStore.INSTANCE.getCountries());
        req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        Role currentRole = UserStore.INSTANCE.getRole(role);
        String password = req.getParameter("password");
        User people = new User(name, login, email, password, currentRole, country, city);
        UserStore.INSTANCE.createUser(people);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
