package ru.job4j.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.job4j.models.EmbeddedEntity;
import ru.job4j.models.File;
import ru.job4j.services.EmbeddedEntityService;
import ru.job4j.services.FileService;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This class represents controller for file.
 * @author Svyatoslav Sabirov.
 * @since 16.08.2018
 * @version 9.
 */
@Controller
@EnableAutoConfiguration
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private EmbeddedEntityService embeddedEntityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String enterPoint(ModelMap model) {
        return "start";
    }

    @RequestMapping(value = "/table", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getListFolders(@RequestParam String path) {
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!path.equals("")) {
            File file = new File(path);
            fileService.addFile(file);
        }
        JSONObject jsonName = new JSONObject();
        JSONArray array = new JSONArray();
        List<File> list = fileService.getAll();
        list.forEach(s-> {
            Set<EmbeddedEntity> embeddedEntityList = s.getList();
/*            long files = s.getList().stream().filter(file -> file.isFolder()).count();
            long folders = list.size() - files;
            long size = s.getList().stream().mapToLong(EmbeddedEntity::getSize).sum();*/
            int files = 0, folders = 0, size = 0;
            for (EmbeddedEntity embeddedEntity : embeddedEntityList) {
                if (embeddedEntity.isFolder()) {
                    folders++;
                } else {
                    files++;
                }
                size += embeddedEntity.getSize();
            }
            JSONObject jsonModel = new JSONObject();
            jsonModel.put("path", s.getPath());
            jsonModel.put("id", s.getId());
            try {
                jsonModel.put("created", oldDateFormat.format(oldDateFormat.parse(s.getCreated().toString())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jsonModel.put("files", files);
            jsonModel.put("folders", folders);
            jsonModel.put("size", size);
            array.add(jsonModel);
        });
        jsonName.put("list", array);
        return jsonName.toString();
    }

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public String showAdvertisementsTable(ModelMap model, @RequestParam String id) {
        model.addAttribute("files", fileService.getFileById(Long.parseLong(id)).getList());
        return "files";
    }
}
