package com.mjc.school.util;

import com.mjc.school.controller.NewsController;
import com.mjc.school.service.model.dto.NewsCdo;

import java.util.List;

public class MenuHelper {
    private final Narrator narrator;

    public MenuHelper() {
        this.narrator = new Narrator(MenuHelper.class, TalkingAt.Left);
    }

    public void printMainMenu() {
        narrator.sayln("Enter the number of operation:");
        for (Operations operation : Operations.values()) {
            narrator.sayln(operation.getOperationWithNumber());
        }
    }

    public void getNews(NewsController newsController) {
        narrator.sayln(Operations.GET_ALL_NEWS.getOperation());
        List<?> newsList = newsController.readAll();
        newsList.forEach(news -> narrator.sayln(news.toString()));
    }

    public void getNewsById(NewsController newsController, ConsoleUtil consoleUtil) {
        narrator.sayln(Operations.GET_NEWS_BY_ID.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf("Enter news id"));
        narrator.sayln(newsController.readById(newsId).toString());
    }

    public void createNews(NewsController newsController, ConsoleUtil consoleUtil) {
        narrator.sayln(Operations.CREATE_NEWS.getOperation());
        String title = consoleUtil.getValueOf("Enter news title");
        String content = consoleUtil.getValueOf("Enter news content");
        Long authorId = Long.parseLong(consoleUtil.getValueOf("Enter author id"));
        NewsCdo newsCdo = NewsCdo.builder()
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
        narrator.sayln(newsController.create(newsCdo).toString());
    }

    public void updateNews(NewsController newsController, ConsoleUtil consoleUtil) {
        narrator.sayln(Operations.UPDATE_NEWS.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf("Enter news id"));
        String title = consoleUtil.getValueOf("Enter news title");
        String content = consoleUtil.getValueOf("Enter news content");
        Long authorId = Long.parseLong(consoleUtil.getValueOf("Enter author id"));
        NewsCdo newsCdo = NewsCdo.builder()
                .id(newsId)
                .title(title)
                .content(content)
                .authorId(authorId)
                .build();
        narrator.sayln(newsController.update(newsCdo).toString());
    }

    public void deleteNews(NewsController newsController, ConsoleUtil consoleUtil) {
        narrator.sayln(Operations.REMOVE_NEWS_BY_ID.getOperation());
        Long newsId = Long.parseLong(consoleUtil.getValueOf("Enter news id"));
        narrator.sayln(newsController.delete(newsId).toString());
    }
}
