package ru.job4j.services;

import ru.job4j.models.Reference;
import java.util.List;

/**
 * This class represents repository for reference.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 7.
 */
public interface ReferenceRepository {
    Reference getReferenceById(int id);
    Reference addReference(Reference reference);
    List<Reference> getAll();
}
