package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;
import ru.job4j.servletpool.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents servlet for edit user.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        UserStore.INSTANCE.updateUser(login, email, name);
        resp.sendRedirect(String.format("%s/",req.getContextPath()));
        //doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String login = req.getParameter("id");
         List<User> list = new ArrayList<>();
         list.add(UserStore.INSTANCE.getUser(login));
         req.setAttribute("users", list);
         req.getRequestDispatcher("edit.jsp").forward(req, resp);
        /*
        String login = req.getParameter("id");
        User user = UserStore.INSTANCE.getUser(login);
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
         writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <title>User list</title>" +
                "</head>" +
                "<body>" +
                "Edit current user: <br/>" +
                "<form action='"+req.getContextPath()+"/edit' method='get'>" +
                "<input type = 'text' name = 'id' value = '" + user.getLogin() +"'> <br/>" +
                "<input type = 'text' name = 'name' value = '" + user.getName() +"'> <br/>" +
                "<input type = 'text' name = 'email' value = '" + user.getEmail() +"'> <br/>" +
                "<input type = 'submit' value = 'Save'>" +
                "</form>" +
                "<form action='"+req.getContextPath()+"/list' method='get'>" +
                "<input type = 'submit' value = 'back'>" +
                "</form>" +
                "</body>" +
                "</html>");
        writer.flush();
        */
    }
}
