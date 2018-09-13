package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.EmbeddedEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents embedded entity service.
 * @author Svyatoslav Sabirov.
 * @since 18.08.2018
 * @version 12.
 */
@Service
public class EmbeddedEntityService implements EmbeddedEntityRepository {

    @Autowired
    private EmbeddedEntityCrud embeddedEntityCrud;

    @Override
    public EmbeddedEntity addEmbeddedEntity(EmbeddedEntity file) {
        return embeddedEntityCrud.save(file);
    }

    @Override
    public List<EmbeddedEntity> getAll() {
        List<EmbeddedEntity> list = new ArrayList<>();
        embeddedEntityCrud.findAll().forEach(s -> list.add(s));
        return list;
    }

    @Override
    public EmbeddedEntity getFileById(long id) {
        return embeddedEntityCrud.findById(id).get();
    }
}
