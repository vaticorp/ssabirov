package ru.job4j.services;

import ru.job4j.models.File;

import java.util.List;

/**
 * This class represents interface-service for file.
 * @author Svyatoslav Sabirov.
 * @since 16.08.2018
 * @version 7.
 */
public interface FileRepository {
    File addFile(File file);
    List<File> getAll();
    File getFileById(long id);
}
