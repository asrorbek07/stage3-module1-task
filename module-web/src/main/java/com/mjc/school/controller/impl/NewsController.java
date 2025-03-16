package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsDto;

import java.util.List;

public class NewsController implements BaseController<NewsDto> {
    private final NewsService<NewsDto> newsService;

    public NewsController() {
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    @Override
    public NewsDto create(NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    @Override
    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return newsService.update(newsDto);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
