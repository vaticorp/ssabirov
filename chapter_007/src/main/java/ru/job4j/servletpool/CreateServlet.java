package ru.job4j.servletpool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents servlet for create users.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User people = new User(name, login, email);
        UserStore.INSTANCE.createUser(people);
        doGet(req, resp);
    }
}
