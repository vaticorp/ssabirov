/*
package ru.job4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

*/
/**
 * This class represents controller for auth.
 * @author Svyatoslav Sabirov.
 * @since 17.06.2018
 * @version 9.
 *//*

@Controller
public class EnterController {

    @RequestMapping(value = "/auto", method = RequestMethod.GET)
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
    }

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String failToEnter() {
        return "fail";
    }
}
*/
