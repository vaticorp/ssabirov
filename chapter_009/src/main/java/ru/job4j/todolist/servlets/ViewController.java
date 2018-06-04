package ru.job4j.todolist.servlets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.job4j.todolist.hibernate.ItemContext;
import ru.job4j.todolist.hibernate.ItemRunner;
import ru.job4j.todolist.model.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * This class represents Controller for servlets.
 * @author Svyatoslav Sabirov.
 * @since 10.05.2018
 * @version 7.
 */
public class ViewController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String idTask = req.getParameter("idTask");
        if (idTask != null) {
            ItemRunner.INSTANCE.updateEntity(Long.parseLong(idTask));
        } else {
            Item item = new Item(description);
            ItemRunner.INSTANCE.addEntity(item);
        }
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = Boolean.parseBoolean(req.getParameter("flag"));
        List<Item> itemList = ItemRunner.INSTANCE.getListItemsByStatus(status);
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        JSONObject main = new JSONObject();
        JSONArray array = new JSONArray();
        for (Item currentItem : itemList) {
            JSONObject itemJson = new JSONObject();
            itemJson.put("id", currentItem.getId());
            itemJson.put("desc", currentItem.getDesc());
            itemJson.put("created", currentItem.getCreated().getTime());
            itemJson.put("done", currentItem.getDone());
            array.add(itemJson);
        }
        main.put("items", array);
        writer.append(main.toJSONString());
        writer.flush();
    }
}
