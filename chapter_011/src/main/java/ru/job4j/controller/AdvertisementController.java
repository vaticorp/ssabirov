package ru.job4j.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import ru.job4j.hibernate.*;
import ru.job4j.models.*;
import ru.job4j.template.advertisement.AdvertisementService;
import ru.job4j.template.body.BodyService;
import ru.job4j.template.brand.BrandService;
import ru.job4j.template.car.CarService;
import ru.job4j.template.category.CategoryService;
import ru.job4j.template.model.ModelService;
import ru.job4j.template.user.UserService;
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
import javax.validation.Valid;

/**
 * This class represents controller for Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 08.06.2018
 * @version 7.
 */

@Controller
public class AdvertisementController implements ServletContextAware {

    ServletContext context;

    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BodyService bodyService;
    @Autowired
    ModelService modelService;
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;
    @Autowired
    AdvertisementService advertisementService;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAdvertisementsTable(ModelMap model) {
        model.addAttribute("brandies", brandService.getAll());
        return "main";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addAdvertisementsView(ModelMap model) {
        Car car = new Car();
        car.setMileage(12345);
        model.addAttribute("car", car);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("bodies", bodyService.getAll());
        model.addAttribute("brandies", brandService.getAll());
        model.addAttribute("bodies", bodyService.getAll());
        return "add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST) //@ModelAttribute("car")
    public String saveNewAdvertisements(HttpServletRequest req, HttpServletResponse resp, @Valid Car newCar, BindingResult result, ModelMap model) throws ServletException, IOException {
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
            //Car newCar = new Car();
            HttpSession session = req.getSession();
            User user = userService.getUserByID(1);
            Advertisement advertisement = new Advertisement();
            advertisement.setUser(user);
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    if (fieldName.equals("brand")) {
                        newCar.setBrand(brandService.getBrandByID(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("models")) {
                        newCar.setModel(modelService.getModelByID(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("category")) {
                        newCar.setCategory(categoryService.getCategoryByID(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("body")) {
                        newCar.setBody(bodyService.getUserByID(Integer.parseInt(item.getString())));
                    } else if (fieldName.equals("mileage")) {
                        newCar.setMileage(Integer.parseInt(item.getString()));
                    }  else if (fieldName.equals("cost")) {
                        advertisement.setCost(Integer.parseInt(item.getString()));
                    } else if (fieldName.equals("created")) {
                        newCar.setCreated(Timestamp.valueOf(String.format("%s %s", item.getString(), "00:00:00")));
                    }
                } else {
                    newCar.setImageArray(item.get());
                }
            }
            carService.addCar(newCar);
            advertisement.setCar(newCar);
            advertisementService.addAdvertisement(advertisement);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return "redirect:/list";
        //return "test";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCheckedAdvertisement(ModelMap model, @RequestParam String id) {
        model.addAttribute("userID", 1); //Без авторизации пока будем брать администратора
        model.addAttribute("advertisement", advertisementService.getAdvertisementByID(Integer.parseInt(id)));
        return "edit";
    }

    @RequestMapping(value = "/json", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String getInformationByFilter(@RequestParam String filter, @RequestParam String brand) {
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        List<Advertisement> list = null;
        Date dateCreated = null;
        Date datePublic = null;
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (filter.equals("last day")) {
            list = advertisementService.findByPublication(AdvertisementRunner.INSTANCE.getStartDay());
        } else if (filter.equals("with image")) {
            list = advertisementService.findByImage();
        } else if (filter.equals("by producer")) {
            list = advertisementService.findByBrand(Integer.parseInt(brand));
        } else if (filter.equals("no filter")) {
            list = advertisementService.getAll();
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
        Brand currentBrand = brandService.getBrandByID(Integer.parseInt(brand));
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
        Advertisement advertisement = advertisementService.getAdvertisementByID(Integer.parseInt(id));
        advertisement.setSoldOut(true);
        advertisementService.addAdvertisement(advertisement);
        return "redirect:/list";
    }
    @RequestMapping(value = "/image", produces = "image/gif", method = RequestMethod.GET)
    @ResponseBody
    public void viewImage(@RequestParam String id, HttpServletResponse resp) throws ServletException, IOException  {
        Car car = carService.getCarByID(Integer.parseInt(id));
        byte[] bytes = car.getImageArray();
        resp.setContentType("image/gif");
        resp.getOutputStream().write(bytes);
        resp.flushBuffer();
    }
}

