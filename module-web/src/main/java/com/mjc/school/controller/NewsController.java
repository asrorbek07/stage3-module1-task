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

    public NewsRdo register(NewsCdo newsCdo) {
        //
        return newsService.register(newsCdo);
    }

    public List<NewsRdo> findAll() {
        //
        return newsService.findAll();
    }

    public NewsRdo findById(Long id) {
        //
        return newsService.findById(id);
    }

    public NewsRdo modify(Long id, NewsCdo newsCdo) {
        //
        return newsService.modify(id, newsCdo);
    }

    public Boolean remove(Long id) {
        //
        return newsService.remove(id);
    }
}
