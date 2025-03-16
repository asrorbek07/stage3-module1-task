package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsRequestDto;
import com.mjc.school.service.model.dto.NewsResponseDto;

import java.util.List;

public class NewsController implements BaseController<Long, NewsRequestDto, NewsResponseDto> {
    private final NewsService<Long, NewsRequestDto, NewsResponseDto> newsService;

    public NewsController() {
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        return newsService.create(newsRequestDto);
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsResponseDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        return newsService.update(newsRequestDto);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
