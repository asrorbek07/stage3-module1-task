package com.mjc.school.controller;

import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;

import java.util.List;

public class NewsController {
    //
    private final NewsService<Long, NewsCdo, NewsRdo> newsService;

    public NewsController() {
        //
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    public NewsRdo create(NewsCdo newsCdo) {
        //
        return newsService.create(newsCdo);
    }

    public List<NewsRdo> readAll() {
        //
        return newsService.readAll();
    }

    public NewsRdo readById(Long id) {
        //
        return newsService.readById(id);
    }

    public NewsRdo update(NewsCdo newsCdo) {
        //
        return newsService.update(newsCdo);
    }

    public Boolean delete(Long id) {
        //
        return newsService.delete(id);
    }
}
