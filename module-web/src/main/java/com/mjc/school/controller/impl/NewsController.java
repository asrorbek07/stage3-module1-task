package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;

import java.util.List;

public class NewsController implements BaseController<Long, NewsCdo, NewsRdo> {
    private final NewsService<Long, NewsCdo, NewsRdo> newsService;

    public NewsController() {
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    @Override
    public NewsRdo create(NewsCdo newsCdo) {
        return newsService.create(newsCdo);
    }

    @Override
    public List<NewsRdo> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsRdo readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsRdo update(NewsCdo newsCdo) {
        return newsService.update(newsCdo);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
