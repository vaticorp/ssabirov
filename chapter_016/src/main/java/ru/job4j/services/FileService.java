package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.File;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service-class for file.
 * @author Svyatoslav Sabirov.
 * @since 16.08.2018
 * @version 12.
 */
@Service
public class FileService implements FileRepository {

    @Autowired
    private FileCrud fileCrud;

    @Override
    public File addFile(File file) {
        return fileCrud.save(file);
    }

    @Override
    public List<File> getAll() {
        List<File> list = new ArrayList<>();
        fileCrud.findAll().forEach(s -> list.add(s));
        return list;
    }

    @Override
    public File getFileById(long id) {
        return fileCrud.findById(id).get();
    }
}
