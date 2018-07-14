package ru.job4j.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.models.Reference;

import java.util.List;

/**
 * This class represents interface for references-crud.
 * @author Svyatoslav Sabirov.
 * @since 09.07.2018
 * @version 14.
 */
public interface ReferenceCrud extends CrudRepository<Reference, Integer> {
    @Query("select ref from Reference ref where ref.user.accountID =:login")
    List<Reference> getReferencesByAccountID(@Param("login") String login);
    @Query("select ref from Reference ref where ref.shortUrl =:url")
    Reference getReferencesByShortUrl(@Param("url") String url);
}
