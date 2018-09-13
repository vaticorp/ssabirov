package ru.job4j.services;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.File;

/**
 * This class represents crud-repository for file.
 * @author Svyatoslav Sabirov.
 * @since 16.08.2018
 * @version 10.
 */
public interface FileCrud extends CrudRepository<File, Long> {
}
