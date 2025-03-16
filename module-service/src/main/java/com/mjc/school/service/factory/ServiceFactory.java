package com.mjc.school.service.factory;

import com.mjc.school.service.NewsService;
import com.mjc.school.service.impl.NewsServiceLogic;
import com.mjc.school.service.model.dto.NewsDto;

public class ServiceFactory {
    //
    private final NewsService<NewsDto> newsService;

    public ServiceFactory() {
        this.newsService = new NewsServiceLogic();
    }

    public static ServiceFactory getInstance() {
        //
        return LazyServiceFactory.LAZY_SERVICE_FACTORY;
    }


    public NewsService<NewsDto> getNewsService() {
        //
        return this.newsService;
    }

    private static class LazyServiceFactory {
        //
        static final ServiceFactory LAZY_SERVICE_FACTORY = new ServiceFactory();
    }

}
