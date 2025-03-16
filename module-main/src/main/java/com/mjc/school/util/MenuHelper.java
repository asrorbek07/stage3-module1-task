package com.mjc.school.util;

import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.service.model.dto.NewsDto;

import java.util.List;

public class MenuHelper {
    private final Narrator narrator;
    private final NewsController newsController;
    private final ConsoleUtil consoleUtil;

    public MenuHelper(Narrator narrator, NewsController newsController) {
        this.narrator = narrator;
        this.newsController = newsController;
        this.consoleUtil = new ConsoleUtil(narrator);
    }

    public void printMainMenu() {
        narrator.sayln(Constant.NUMBER_OPERATION_ENTER);
        for (Operations operation : Operations.values()) {
            narrator.sayln(operation.getOperationWithNumber());
        }
    }

    public void getNews() {
        narrator.sayln(Operations.GET_ALL_NEWS.getOperation());
        List<?> newsList = newsController.readAll();
        newsList.forEach(news -> narrator.sayln(news.toString()));
    }

    public void getNewsById() {
        narrator.sayln(Operations.GET_NEWS_BY_ID.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf(Constant.NEWS_ID_ENTER));
        narrator.sayln(newsController.readById(newsId).toString());
    }

    public void createNews() {
        narrator.sayln(Operations.CREATE_NEWS.getOperation());
        String title = consoleUtil.getValueOf(Constant.NEWS_TITLE_ENTER);
        String content = consoleUtil.getValueOf(Constant.NEWS_CONTENT_ENTER);
        Long authorId = Long.parseLong(consoleUtil.getValueOf(Constant.AUTHOR_ID_ENTER));
        NewsDto newsDto = NewsDto.builder()
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
        narrator.sayln(newsController.create(newsDto).toString());
    }

    public void updateNews() {
        narrator.sayln(Operations.UPDATE_NEWS.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf(Constant.NEWS_ID_ENTER));
        String title = consoleUtil.getValueOf(Constant.NEWS_TITLE_ENTER);
        String content = consoleUtil.getValueOf(Constant.NEWS_CONTENT_ENTER);
        Long authorId = Long.parseLong(consoleUtil.getValueOf(Constant.AUTHOR_ID_ENTER));
        NewsDto newsDto = NewsDto.builder()
                .id(newsId)
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
        narrator.sayln(newsController.update(newsDto).toString());
    }

    public void deleteNews() {
        narrator.sayln(Operations.REMOVE_NEWS_BY_ID.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf(Constant.NEWS_ID_ENTER));
        narrator.sayln(newsController.delete(newsId).toString());
    }
}