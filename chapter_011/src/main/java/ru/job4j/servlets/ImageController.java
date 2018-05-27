package ru.job4j.servlets;

import ru.job4j.hibernate.CarRunner;
import ru.job4j.models.Car;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This class represents image-servlet.
 * @author Svyatoslav Sabirov.
 * @since 22.05.2018
 * @version 7.
 */
public class ImageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Car car = CarRunner.INSTANCE.getEntryById(Integer.parseInt(id));
        byte[] bytes = car.getImageArray();
        resp.setContentType("image/gif");
        resp.getOutputStream().write(bytes);
        resp.flushBuffer();
    }
}
