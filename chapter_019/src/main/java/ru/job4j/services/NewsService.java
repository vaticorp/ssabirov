package ru.job4j.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.News;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service-class for News.
 * @author Svyatoslav Sabirov.
 * @since 03.10.2018
 * @version 10.
 */
@Service
public class NewsService implements NewsRepository {

    @Autowired
    NewsCrud newsCrud;

    @Override
    public List<News> getAll() {
        List<News> list = new ArrayList<News>();
       this.newsCrud.findAll().forEach(current -> list.add(current));
        return list;
    }

    public List<News> getNewsByPageNumber(int begin, int end) {
        return newsCrud.getNewsByPageNumber(begin, end);
    }

    @Override
    public News getNewsById(Long id) {
        return this.newsCrud.findById(id).get();
    }

    @Override
    public News addNews(News news) {
        return this.newsCrud.save(news);
    }

    @Override
    public News editNews(News news) {
        return this.newsCrud.save(news);
    }
}
