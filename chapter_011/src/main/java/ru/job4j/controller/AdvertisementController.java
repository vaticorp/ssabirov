package ru.job4j.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.;
import org.springframework.web.bind.annotation.;*/
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.hibernate.*;
import ru.job4j.models.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class represents controller for Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 08.06.2018
 * @version 7.
 */

@Controller
public class AdvertisementController {

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAdvertisementsTable(ModelMap model) {
        model.addAttribute("brandies", BrandRunner.INSTANCE.getAllEntry());
        return "main";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addAdvertisementsView(ModelMap model) {
        model.addAttribute("categories", CategoryRunner.INSTANCE.getAllEntry());
        model.addAttribute("bodies", BodyRunner.INSTANCE.getAllEntry());
        model.addAttribute("brandies", BrandRunner.INSTANCE.getAllEntry());
        return "add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveNewAdvertisements(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        if (!isMultipart) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) context.getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);
        try {
            List<FileItem> items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            Car newCar = new Car();
            /*HttpSession session = req.getSession();*/
            User user = UserRunner.INSTANCE.getEntryById(1);
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
                    } else if (fieldName.equals("release")) {
                        newCar.setCreated(Timestamp.valueOf(String.format("%s %s", item.getString(), "00:00:00")));
                    }
                } else {
                    newCar.setImageArray(item.get());
                }
            }
            CarRunner.INSTANCE.addEntry(newCar);
            advertisement.setCar(newCar);
            AdvertisementRunner.INSTANCE.addAdvertisement(advertisement);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCheckedAdvertisement(ModelMap model, @RequestParam String id) {
        model.addAttribute("userID", 1); //Без авторизации пока будем брать администратора
        model.addAttribute("advertisement", AdvertisementRunner.INSTANCE.getEntryById(Integer.parseInt(id)));
        return "edit";
    }

    @RequestMapping(value = "/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestParam String filter, @RequestParam String brand) {
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
            list = AdvertisementRunner.INSTANCE.getAdvertisementByBrandId(brand);
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
        return jsonName.toString();
    }

    @RequestMapping(value = "/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getModelList(@RequestParam String brand) {
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        Brand currentBrand = BrandRunner.INSTANCE.getEntryById(Integer.parseInt(brand));
        Set<Model> models = currentBrand.getModels();
        for (Model model : models) {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("id", model.getId());
            jsonModel.put("name", model.getName());
            array.add(jsonModel);
        }
        jsonName.put("models", array);
        jsonName.put("list", array);
        return jsonName.toString();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String setSoldToAdvertisement(ModelMap model, @RequestParam String id) {
        Advertisement advertisement = AdvertisementRunner.INSTANCE.getEntryById(Integer.parseInt(id));
        advertisement.setSoldOut(true);
        AdvertisementRunner.INSTANCE.updateAdvertisement(advertisement);
        return "redirect:/list";
    }

    @RequestMapping(value = "/image", produces = "image/gif", method = RequestMethod.GET)
    @ResponseBody
    public void viewImage(@RequestParam String id, HttpServletResponse resp) throws ServletException, IOException  {
        Car car = CarRunner.INSTANCE.getEntryById(Integer.parseInt(id));
        byte[] bytes = car.getImageArray();
        resp.setContentType("image/gif");
        resp.getOutputStream().write(bytes);
        resp.flushBuffer();
    }
}

