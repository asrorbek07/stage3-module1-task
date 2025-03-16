package com.mjc.school.controller.impl;

import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsDto;

import java.util.List;

public class NewsController {
    private final NewsService<NewsDto> newsService;

    public NewsController() {
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    public NewsDto create(NewsDto newsDto) {
        return newsService.create(newsDto);
    }

    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    public NewsDto readById(Long id) {
        return newsService.readById(id);
    }

    public NewsDto update(NewsDto newsDto) {
        return newsService.update(newsDto);
    }

    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
