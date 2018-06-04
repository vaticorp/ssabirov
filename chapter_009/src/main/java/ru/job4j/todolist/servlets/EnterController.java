package ru.job4j.todolist.servlets;

import ru.job4j.todolist.hibernate.UserRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents servlet for enter.
 * @author Svyatoslav Sabirov.
 * @since 12.05.2018
 * @version 7.
 */
public class EnterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/Auto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (UserRunner.INSTANCE.userExist(login, password)) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
            }
            resp.sendRedirect(String.format("%s/index.html", req.getContextPath()));
        } else {
            req.setAttribute("error", "User not found!");
            doGet(req, resp);
        }
    }
}
