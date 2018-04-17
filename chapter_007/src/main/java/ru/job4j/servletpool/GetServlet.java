package ru.job4j.servletpool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

/**
 * This class represents servlet for getting users.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class GetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        List<User> userList = UserStore.INSTANCE.getUsers();
        StringBuilder stringTabel = new StringBuilder("<table border = '2' bgcolor = '#efefef'>");
        for (User currentUser : userList) {
            stringTabel.append("<tr><td>")
            .append(currentUser.getName())
            .append("</td><td>")
            .append(currentUser.getLogin())
            .append("</td><td>")
            .append(currentUser.getEmail())
            .append("</td><td>")
            .append("<form action='"+req.getContextPath()+"/edit?id="+currentUser.getLogin()+"' method='post'><input type = 'submit' value = 'Edit'></form>")
            .append("</td><td>")
            .append("<form action='"+req.getContextPath()+"/list' method='post'><input type = 'submit' name = '"+currentUser.getLogin()+"' value = 'Remove'></form>")
            .append("</td></tr>");
        }
        stringTabel.append("</table>");
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>User list</title>" +
                "</head>" +
                "<body>" +
                //"<form action='"+req.getContextPath()+"/create'" +
                 "User list: <br/>" +
                 stringTabel.toString() +
                "<form action='"+req.getContextPath()+"/create' method='get'>" +
                "<button type='submit'>Create new user</button> "+
                "</form>" +
                 "</body>" +
                "</html>");
        writer.flush();
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> im = req.getParameterNames();
        String login = im.nextElement();
        UserStore.INSTANCE.deleteUser(login);
        resp.sendRedirect(String.format("%s/index.jsp",req.getContextPath()));
    }
}
