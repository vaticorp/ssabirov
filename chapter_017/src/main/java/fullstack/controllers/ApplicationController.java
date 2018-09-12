package fullstack.controllers;

import fullstack.models.Task;
import fullstack.services.TaskService;
import fullstack.services.UserService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * This class represents main-controller for application.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 12.
 */
@Controller
@EnableAutoConfiguration
public class ApplicationController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() {
        return "start";
    }

    @RequestMapping(value = "/tasks", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getListTasks() {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Task> taskList = taskService.getAll();
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        taskList.forEach(s -> {
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("id", s.getId());
            jsonModel.put("name", s.getName());
            jsonModel.put("category", s.getCategory());
            try {
                jsonModel.put("dateStart", oldDateFormat.format(oldDateFormat.parse(s.getDateStart().toString())));
                jsonModel.put("dateEnd", oldDateFormat.format(oldDateFormat.parse(s.getDateEnd().toString())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jsonModel.put("status", s.getStatus());
            array.add(jsonModel);
        });
        jsonName.put("list", array);
        return jsonName.toString();
    }

    @RequestMapping(value = "/tasks/{number}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getTask(@PathVariable("number") String id) {
        JSONObject jsonModel = new JSONObject();
        Task task = taskService.getTaskById(Long.parseLong(id));
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        jsonModel.put("id", task.getId());
        jsonModel.put("name", task.getName());
        jsonModel.put("category", task.getCategory());
        try {
            jsonModel.put("dateStart", oldDateFormat.format(oldDateFormat.parse(task.getDateStart().toString())));
            jsonModel.put("dateEnd", oldDateFormat.format(oldDateFormat.parse(task.getDateEnd().toString())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonModel.put("status", task.getStatus());
        return jsonModel.toString();
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public String addNewTask(@ModelAttribute Task task, BindingResult result, Model model) {
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.DELETE)
    public String deleteTask(@ModelAttribute Task task, BindingResult result, Model model) {
        taskService.removeTask(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public String updateTask(@ModelAttribute Task task, BindingResult result, Model model) {
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

}
