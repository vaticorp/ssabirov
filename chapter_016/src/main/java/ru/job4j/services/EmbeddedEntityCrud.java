package ru.job4j.services;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.EmbeddedEntity;

/**
 * This class represents embedded entity for Crud.
 * @author Svyatoslav Sabirov.
 * @since 18.08.2018
 * @version 10.
 */
public interface EmbeddedEntityCrud extends CrudRepository<EmbeddedEntity, Long> {
}
