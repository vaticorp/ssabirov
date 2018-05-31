package ru.job4j.servlets;

import ru.job4j.hibernate.AdvertisementRunner;
import ru.job4j.hibernate.BrandRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This class represents servlet for start.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class ViewController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brandies", BrandRunner.INSTANCE.getAllEntry());
        req.getRequestDispatcher("WEB-INF/views/main.jsp").forward(req, resp);
    }
}
