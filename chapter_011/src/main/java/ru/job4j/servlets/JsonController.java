package ru.job4j.servlets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.job4j.hibernate.AdvertisementRunner;
import ru.job4j.hibernate.BrandRunner;
import ru.job4j.hibernate.ModelRunner;
import ru.job4j.models.Advertisement;
import ru.job4j.models.Brand;
import ru.job4j.models.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filter = req.getParameter("filter");
        String idBrand = req.getParameter("brand");
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        List<Advertisement> list = null;
        Date dateCreated = null;
        Date datePublic = null;
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (filter.equals("last day")) {
            list = AdvertisementRunner.INSTANCE.getAdvertisementByActualDay();
        } else if (filter.equals("with image")) {
            list = AdvertisementRunner.INSTANCE.getAdvertisementByImage();
        } else if (filter.equals("by producer")) {
            list = AdvertisementRunner.INSTANCE.getAdvertisementByBrandId(idBrand);
        } else if (filter.equals("no filter")) {
            list = AdvertisementRunner.INSTANCE.getAllEntry();
        }
        for (Advertisement adv : list) {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("producer", adv.getCar().getBrand().getName());
            jsonModel.put("model", adv.getCar().getModel().getName());
            jsonModel.put("category", adv.getCar().getCategory().getName());
            jsonModel.put("body", adv.getCar().getBody().getName());
            jsonModel.put("mileage", adv.getCar().getMileage());
            try {
                dateCreated = oldDateFormat.parse(adv.getCar().getCreated().toString());
                datePublic = oldDateFormat.parse(adv.getPublicationDate().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jsonModel.put("created", oldDateFormat.format(dateCreated));
            jsonModel.put("cost", adv.getCost());
            jsonModel.put("sold", adv.getSoldOut());
            jsonModel.put("public", oldDateFormat.format(datePublic));
            jsonModel.put("id", adv.getId());
            array.add(jsonModel);
        }
        jsonName.put("list", array);
        writer.append(jsonName.toJSONString());
        writer.flush();
    }
}
