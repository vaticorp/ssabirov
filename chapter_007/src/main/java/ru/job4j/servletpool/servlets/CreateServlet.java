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
        req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
        /*
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>User list</title>" +
                "</head>" +
                "<body>" +
                "Create new user: <br/>" +
                "<form action='"+req.getContextPath()+"/create' method='post'>" +
                "<p>Login: " +
                "<input type = 'text' name = 'login'> <br/>" +
                "</p>" +
                "<p>Name: " +
                "<input type = 'text' name = 'name'> <br/>" +
                "</p>" +
                "<p>E-mail: " +
                "<input type = 'text' name = 'email'> <br/>" +
                "</p>" +
                "<input type = 'submit' value = 'Save'>" +
                "</form>" +
                "<form action='"+req.getContextPath()+"/list' method='get'>" +
                "<input type = 'submit' value = 'Back'>" +
                "</form>" +
                "</body>" +
                "</html>");
        writer.flush();
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        Role currentRole = UserStore.INSTANCE.getRole(role);
        String password = req.getParameter("password");
        User people = new User(name, login, email, password, currentRole);
        UserStore.INSTANCE.createUser(people);
        resp.sendRedirect(String.format("%s/",req.getContextPath()));
    }
}
