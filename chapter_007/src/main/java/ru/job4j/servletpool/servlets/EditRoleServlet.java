package ru.job4j.servletpool.servlets;

import ru.job4j.servletpool.db.UserStore;
import ru.job4j.servletpool.model.Role;
import ru.job4j.servletpool.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents servlet for edit roles.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class EditRoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String name = req.getParameter("name");
        UserStore.INSTANCE.updateRole(name, description);
        resp.sendRedirect(String.format("%s/",req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Role> list = new ArrayList<>();
        list.add(UserStore.INSTANCE.getRole(name));
        req.setAttribute("roles", list);
        req.getRequestDispatcher("editrole.jsp").forward(req, resp);
    }
}
