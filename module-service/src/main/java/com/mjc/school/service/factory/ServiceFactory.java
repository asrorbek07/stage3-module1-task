package com.mjc.school.service.factory;

import com.mjc.school.service.impl.NewsServiceLogic;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.model.dto.NewsDtoRequest;
import com.mjc.school.service.model.dto.NewsDtoResponse;

public class ServiceFactory {
    //
    private final NewsService<Long, NewsDtoRequest, NewsDtoResponse> newsService;

    public ServiceFactory() {
        this.newsService = new NewsServiceLogic();
    }

    public static ServiceFactory getInstance() {
        //
        return LazyServiceFactory.LAZY_SERVICE_FACTORY;
    }


    public NewsService<Long, NewsDtoRequest, NewsDtoResponse> getNewsService() {
        //
        return this.newsService;
    }

    private static class LazyServiceFactory {
        //
        static final ServiceFactory LAZY_SERVICE_FACTORY = new ServiceFactory();
    }

}
