package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This class represents servlet for authorisation and authetication.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class SignController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/Authorisation.jsp").forward(req, resp);
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (UserStore.INSTANCE.userValid(login, password)) {
            HttpSession session = req.getSession();
            synchronized (session) {
                session.setAttribute("login", login);
            }
            resp.sendRedirect(String.format("%s/",req.getContextPath()));
        } else {
            req.setAttribute("error", "User not found!");
            doGet(req, resp);
        }
        //super.doPost(req, resp);
    }
}
