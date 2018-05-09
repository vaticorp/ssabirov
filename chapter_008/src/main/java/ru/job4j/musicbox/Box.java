package ru.job4j.musicbox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class represents main servlet.
 * @author Svyatoslav Sabirov.
 * @since 09.05.2018
 * @version 14.
 */
public class Box extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Тут могла бы быть ваша логика отображения!");
        writer.flush();
    }
}
