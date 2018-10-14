package ru.job4j.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.models.News;

import java.util.List;

/**
 * This class represents crud-repository for News.
 * @author Svyatoslav Sabirov.
 * @since 03.10.2018
 * @version 9.
 */
public interface NewsCrud extends CrudRepository<News, Long> {
    @Query("select current from News current where current.id >= :begin and current.id <= :end")
    List<News> getNewsByPageNumber(@Param("begin") long begin, @Param("end") long end);
}

