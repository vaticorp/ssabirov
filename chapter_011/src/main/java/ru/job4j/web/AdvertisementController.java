package ru.job4j.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
public class AdvertisementController implements ServletContextAware {

    ServletContext context;

    @Autowired
    AdvertisementService advertisementService;
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
    BrandService brandService;

/*    @RequestMapping(value = "/auto", method = RequestMethod.GET)
    public String redirectToEnter() {
        return "Auto";
    }

    @RequestMapping(value = "/j_spring_security_check", method = RequestMethod.POST)
    public String checkToEnter(@RequestParam(value = "logout", required = false) String logout,
                               ModelMap model) {
        if (logout != null) {
            model.addAttribute("logout", "logout in process...Success!");
        }
        return "Auto";
    }*/

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String failToEnter() {
        return "fail";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }

    @InitBinder("advertisement")
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, "car.created",  dateEditor);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAdvertisementsTable(ModelMap model) {
        model.addAttribute("brandies", brandService.getAll());
        return "main";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addAdvertisementsView(ModelMap model) {
        model.addAttribute("advertisement", new Advertisement());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("bodies", bodyService.getAll());
        model.addAttribute("brandies", brandService.getAll());
        model.addAttribute("models", modelService.getAll());
        model.addAttribute("userID", 1);
        return "add";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST) //@ModelAttribute("car") @Valid  @RequestParam LocalDateTime created HttpServletRequest req, HttpServletResponse resp,
    public String saveNewAdvertisements(@ModelAttribute Advertisement advertisement, BindingResult result, Model model) throws ServletException, IOException {
        advertisementService.addAdvertisement(advertisement);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCheckedAdvertisement(ModelMap model, @RequestParam String id) {
        Advertisement advertisement = advertisementService.getAdvertisementByID(Integer.parseInt(id));
        model.addAttribute("userID", 1); //Без авторизации пока будем брать администратора
        model.addAttribute("path", String.format("/image?id=%s",String.valueOf(advertisement.getId())));
        model.addAttribute("advertisement", advertisement);
        return "edit";
    }

    @RequestMapping(value = "/json", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getModelList(@RequestParam String brand, @ModelAttribute Advertisement advertisement) {
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

    @RequestMapping(value = "/filt", produces = "application/json", method = RequestMethod.GET)
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

