package ru.job4j.controllers;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;
import ru.job4j.models.Comment;
import ru.job4j.models.News;
import ru.job4j.services.NewsService;

import java.util.List;
import java.util.Set;

/**
 * This class represents controller-class for news.
 * @author Svyatoslav Sabirov.
 * @since 04.10.2018
 * @version 7.
 */
@Controller
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/news")
    public String getNewsPages(@RequestParam(required = false) String page, ModelMap modelMap) {
        List<News> list = newsService.getAll();
        int value = (page == null) ? 1 : Integer.parseInt(page);
        long maxPage = (list.size() / 5) + 1;
        modelMap.addAttribute("maxPages", maxPage);
        if (value < 1 || value > maxPage) {
            value = 1;
        };
        modelMap.addAttribute("page", page);
        //Возможно,лучше сделать настраиваемый механизм для вывода необходимого количества страниц.
        modelMap.addAttribute("newsList", newsService.getNewsByPageNumber(value * 5 - 4, value * 5));
        return "news";
    }

    @GetMapping(value = "/news/{id}")
    public String getNewsInfo(@PathVariable String id, ModelMap modelMap) {
        modelMap.addAttribute("current", newsService.getNewsById(Long.parseLong(id)));
        return "page";
    }

    @GetMapping(value = "/edit/{id}")
    public String editNewsInfo(@PathVariable String id, ModelMap modelMap) {
        modelMap.addAttribute("current", newsService.getNewsById(Long.parseLong(id)));
        return "edit";
    }

    @GetMapping(value = "/add")
    public String addNews(ModelMap modelMap) {
        modelMap.addAttribute("current", new News());
        return "edit";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String saveNews(@RequestBody News body) {
        News ready = this.newsService.editNews(body);
        return "body-" + ready.getId();
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String testNews(@RequestParam(required = false) String id, ModelMap modelMap) {
/*        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        News news = newsService.getNewsById(Long.parseLong(id));
        Set<Comment> comments = news.getComments();
        for (Comment comment : comments) {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("author", comment.getAuthor());
            jsonModel.put("description", comment.getDescription());
            array.add(jsonModel);
        }
        jsonName.put("comments", array);
        jsonName.put("list", array);
        return jsonName.toString();*/
        return "";
    }
}
