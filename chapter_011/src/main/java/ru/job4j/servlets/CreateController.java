package ru.job4j.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.job4j.hibernate.*;
import ru.job4j.models.Advertisement;
import ru.job4j.models.Car;
import ru.job4j.models.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This class represents controller for new advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class CreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brandies", BrandRunner.INSTANCE.getAllEntry());
        req.setAttribute("categories", CategoryRunner.INSTANCE.getAllEntry());
        req.setAttribute("bodies", BodyRunner.INSTANCE.getAllEntry());
        req.getRequestDispatcher("WEB-INF/views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);
        try {
            List<FileItem> items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            Car newCar = new Car();
            HttpSession session = req.getSession();
            User user = UserRunner.INSTANCE.getEntryById(Integer.parseInt(String.valueOf(session.getAttribute("userId"))));
            Advertisement advertisement = new Advertisement();
            advertisement.setUser(user);
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("brand")) {
                        newCar.setBrand(BrandRunner.INSTANCE.getEntryById(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("models")) {
                        newCar.setModel(ModelRunner.INSTANCE.getEntryById(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("category")) {
                        newCar.setCategory(CategoryRunner.INSTANCE.getEntryById(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("body")) {
                        newCar.setBody(BodyRunner.INSTANCE.getEntryById(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("mileage")) {
                        newCar.setMileage(Integer.parseInt(item.getString()));
                    }  else if (fieldName.equals("cost")) {
                        advertisement.setCost(Integer.parseInt(item.getString()));
                    } /*else if (fieldName.equals("release")) {
                        newCar.setCreated(Timestamp.valueOf(String.format("%s %s", item.getString(), "00:00:00")));
                    }*/
                } else {
                    newCar.setImageArray(item.get());
                }
            }
            CarRunner.INSTANCE.addEntry(newCar);
            advertisement.setCar(newCar);
            AdvertisementRunner.INSTANCE.addAdvertisement(advertisement);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        resp.sendRedirect(String.format("%s/list", req.getContextPath()));
    }
}
