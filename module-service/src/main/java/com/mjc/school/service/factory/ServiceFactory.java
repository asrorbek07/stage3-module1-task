package com.mjc.school.service.factory;

import com.mjc.school.service.impl.NewsServiceLogic;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.model.dto.NewsRequestDto;
import com.mjc.school.service.model.dto.NewsResponseDto;

public class ServiceFactory {
    //
    private final NewsService<Long, NewsRequestDto, NewsResponseDto> newsService;

    public ServiceFactory() {
        this.newsService = new NewsServiceLogic();
    }

    public static ServiceFactory getInstance() {
        //
        return LazyServiceFactory.LAZY_SERVICE_FACTORY;
    }


    public NewsService<Long, NewsRequestDto, NewsResponseDto> getNewsService() {
        //
        return this.newsService;
    }

    private static class LazyServiceFactory {
        //
        static final ServiceFactory LAZY_SERVICE_FACTORY = new ServiceFactory();
    }

}
