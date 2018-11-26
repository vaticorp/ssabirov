package com.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.User;
import com.mybatis.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents main controller  for spring-application.
 * @author Svyatoslav Sabirov.
 * @since 25.11.2018
 * @version 17.
 */
@Controller
public class CatalogController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String startApplication() {
        return "start";
    }

    @RequestMapping (value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<User>> loadAllBooks() {
        Map<String, List<User>> books = new HashMap<String, List<User>>();
        books.put("users", this.userService.getAllUsers());
        return books;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean removeFromCatalog(@RequestBody User user) {
        this.userService.removeUser(user);
        return true;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addToCatalog(HttpServletRequest httpServletRequest) {
        User current = convertRequestDataToObject(httpServletRequest);
        this.userService.addUser(current);
        return true;
    }

    @RequestMapping (value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUser(HttpServletRequest httpServletRequest) {
        User current = convertRequestDataToObject(httpServletRequest);
        this.userService.updateUser(current);
        return true;
    }

    /**
     * При текущих версиях библиотек никак не получалось преобразовать json в объект через параметр тела (@RequestBody User user),
     * поэтому пришлось прибегнуть к ручному преобразованию через mapper, что само по себе не очень.
     * @param httpServletRequest
     * @return
     */
    private static User convertRequestDataToObject(HttpServletRequest httpServletRequest) {
        User current = null;
        String dataUser = httpServletRequest.getParameter("dataDetails");
        ObjectMapper mapper = new ObjectMapper();
        try {
            current = mapper.readValue(dataUser, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return current;
    }
}
