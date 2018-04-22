package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class represents servlet for edit roles.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class RolesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", UserStore.INSTANCE.getRoles());
        req.getRequestDispatcher("/WEB-INF/views/rules.jsp").forward(req, resp);
    }

}
