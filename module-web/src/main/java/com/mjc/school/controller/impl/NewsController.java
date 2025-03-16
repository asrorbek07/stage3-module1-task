package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.factory.ServiceFactory;
import com.mjc.school.service.model.dto.NewsDtoRequest;
import com.mjc.school.service.model.dto.NewsDtoResponse;

import java.util.List;

public class NewsController implements BaseController<Long, NewsDtoRequest, NewsDtoResponse> {
    private final NewsService<Long, NewsDtoRequest, NewsDtoResponse> newsService;

    public NewsController() {
        this.newsService = ServiceFactory.getInstance().getNewsService();
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest newsDtoRequest) {
        return newsService.create(newsDtoRequest);
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest newsDtoRequest) {
        return newsService.update(newsDtoRequest);
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
