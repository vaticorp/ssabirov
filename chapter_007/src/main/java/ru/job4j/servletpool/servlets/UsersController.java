package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * This class represents servlet for getting users.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class UsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("users", UserStore.INSTANCE.getUsers());
        //req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null) {
            req.setAttribute("users", UserStore.INSTANCE.getUsers());
            req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/views/Authorisation.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> im = req.getParameterNames();
        String login = im.nextElement();
        UserStore.INSTANCE.deleteUser(login);
        resp.sendRedirect(String.format("%s/",req.getContextPath()));
    }
}
