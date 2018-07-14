package ru.job4j.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.job4j.models.Reference;
import ru.job4j.models.User;
import ru.job4j.services.ReferenceService;
import ru.job4j.services.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
public class ShortenerController {

    @Autowired
    UserService userService;
    @Autowired
    ReferenceService referenceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String enterPoint(ModelMap model) {
        return "start";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> handleJsonPostRequest(@RequestBody User user) {
        User existUser = userService.findByAccountID(user.getAccountID());
        String result = "";
        if (existUser == null) {
            user.generatePassword(8, 8);
            userService.addUser(user);

            result = "{\"success\": \"true\",\"description\": \"You account is opened\",\"password\": \"" + user.getPassword() + "\"}";
        } else {
            result = "{\"success\": \"false\",\"description\": \"account with that ID is already exists!\"}";
        }
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String authorisation(HttpSession httpSession, @RequestParam(value = "username") String login, @RequestParam(value = "password") String password) {
        User user = userService.findByLoginPassword(login, password);
        if (user == null) { //Возможно, стоит послать текст ошибки...
            return "redirect:/login";
        }
        httpSession.setAttribute("currentUser", user);
        return "register";
    }

    @RequestMapping(value = "/transition", method = RequestMethod.POST)
    public void redirectingUrl(@RequestParam(value = "reflect") String shortReference, HttpServletResponse response, HttpSession httpSession) throws IOException {
        Reference reference = referenceService.getReferencesByShortUrl(shortReference);
        User currentUser = (User) httpSession.getAttribute("currentUser");
        String longUrl = reference.getLongUrl();
        reference.setUser(currentUser);
        referenceService.addReference(reference);
        if (reference.getType().equals("302")) {
            response.sendRedirect(longUrl);
        } else {
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            response.setHeader("Location", longUrl);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerLink(HttpSession httpSession, @RequestBody Reference reference) {
        Reference dbReference = referenceService.addReference(reference);
        dbReference.shortingUrl();
        Reference resultReference = referenceService.addReference(dbReference);
        String result = "{\"description\": \"Shorting URL:" + resultReference.getShortUrl() + "\"}";
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(result, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String statisticPage() {
        return "statistic";
    }

    @RequestMapping(value = "/statistic/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getStatistic(@PathVariable("accountId") String accountId) {
        List<Reference> list = referenceService.getReferencesByAccountID(accountId);
        HashMap<String,Integer> amountMap = new HashMap<>();
        String result = "{";
        for (Reference reference : list) {
            String longUrl = reference.getLongUrl();
            if (amountMap.containsKey(longUrl)) {
                Integer amount = amountMap.get(longUrl);
                amount++;
                amountMap.put(longUrl, amount);
            } else {
                amountMap.put(longUrl, 1);
            }
        }
         for (Map.Entry<String, Integer> entry: amountMap.entrySet()) {
            result += "\"" + entry.getKey() + "\": \"" + String.valueOf(entry.getValue()) + "\",";
        }
        result = (result.length() > 1) ? result.substring(0, result.length() - 1) : result;
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<String>(result += "}" , httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String enterWindow(ModelMap model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("users", userService.getAll());
        return "login";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String showHelp() {
        return "help";
    }
}
