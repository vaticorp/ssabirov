package ru.job4j.services;

import ru.job4j.models.EmbeddedEntity;
import ru.job4j.models.File;

import java.util.List;

/**
 * This class represents interface for Embedded.
 * @author Svyatoslav Sabirov.
 * @since 18.08.2018
 * @version 7.
 */
public interface EmbeddedEntityRepository {
    EmbeddedEntity addEmbeddedEntity(EmbeddedEntity file);
    List<EmbeddedEntity> getAll();
    EmbeddedEntity getFileById(long id);
}
