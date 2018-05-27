package ru.job4j.servlets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.job4j.hibernate.BrandRunner;
import ru.job4j.hibernate.ModelRunner;
import ru.job4j.models.Brand;
import ru.job4j.models.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * This class represents json-controller.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 9.
 */
public class JsonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idBrand = req.getParameter("brand");
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        Brand brand = BrandRunner.INSTANCE.getEntryById(Integer.parseInt(idBrand));
        Set<Model> models = brand.getModels();
        for (Model model : models) {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("id", model.getId());
            jsonModel.put("name", model.getName());
            array.add(jsonModel);
        }
        jsonName.put("models", array);
        writer.append(jsonName.toJSONString());
        writer.flush();
    }
}
