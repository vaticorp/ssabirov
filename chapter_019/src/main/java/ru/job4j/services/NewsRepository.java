package ru.job4j.services;

import ru.job4j.models.News;

import java.util.List;

/**
 * This class represents interface-repository for News.
 * @author Svyatoslav Sabirov.
 * @since 03.10.2018
 * @version 7.
 */
public interface NewsRepository {
    List<News> getAll();
    News getNewsById(Long id);
    News addNews(News news);
    News editNews(News news);
}
