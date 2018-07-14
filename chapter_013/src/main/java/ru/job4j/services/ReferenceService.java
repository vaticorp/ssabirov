package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Reference;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for references.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 10.
 */
@Service
@Transactional
public class ReferenceService implements ReferenceRepository {

    @Autowired
    private ReferenceCrud referenceCrud;

    @Override
    public Reference getReferenceById(int id) {
        return referenceCrud.findById(id).get();
    }

    @Override
    public Reference addReference(Reference reference) {
        return referenceCrud.save(reference);
    }

    @Override
    public List<Reference> getAll() {
        List<Reference> list = new ArrayList<Reference>();
        referenceCrud.findAll().forEach(current -> list.add(current));
        return list;
    }

    public List<Reference> getReferencesByAccountID(String accountID) {
        return referenceCrud.getReferencesByAccountID(accountID);
    }

    public Reference getReferencesByShortUrl(String url) {
        return referenceCrud.getReferencesByShortUrl(url);
    }
}
