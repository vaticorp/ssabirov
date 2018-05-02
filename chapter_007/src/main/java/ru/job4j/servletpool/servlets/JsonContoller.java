package ru.job4j.servletpool.servlets;

import org.json.simple.*;
import ru.job4j.servletpool.db.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * This class represents servlet for servlet.
 * @author Svyatoslav Sabirov.
 * @since 11.04.2018
 * @version 9.
 */
public class JsonContoller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pas = req.getParameter("pas");
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        JSONObject jsonName = new JSONObject();
        if (UserStore.INSTANCE.userValid(name, pas)) {
            HttpSession session = req.getSession();
            session.setAttribute("login", name);
            jsonName.put("valid",true);
        }
        writer.append(jsonName.toJSONString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        List<String> cities = UserStore.INSTANCE.getCities(country);
        for (String city : cities) {
            array.add(city);
        }
        jsonName.put("cities",array);
        writer.append(jsonName.toJSONString());
        writer.flush();
    }
}
