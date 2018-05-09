package ru.job4j.repository;

import ru.job4j.models.Role;
import ru.job4j.repository.CommonSpecification;

import java.util.List;

/**
 * This class represents Role.
 * @author Svyatoslav Sabirov.
 * @since 07.05.2018
 * @version 7.
 */ 
public interface Repository<T> {
    List<T> query(CommonSpecification<T> specification);
}
