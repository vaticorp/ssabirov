package ru.job4j.servlets;

import ru.job4j.hibernate.AdvertisementRunner;
import ru.job4j.models.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This class represents servlet for edit advertisement.
 * @author Svyatoslav Sabirov.
 * @since 25.05.2018
 * @version 9.
 */
public class EditController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("advertisement", AdvertisementRunner.INSTANCE.getEntryById(id));
        HttpSession session = req.getSession();
        req.setAttribute("userID", (Integer) session.getAttribute("userId"));
        req.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Advertisement advertisement = AdvertisementRunner.INSTANCE.getEntryById(Integer.parseInt(id));
        advertisement.setSoldOut(true);
        AdvertisementRunner.INSTANCE.updateAdvertisement(advertisement);
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
