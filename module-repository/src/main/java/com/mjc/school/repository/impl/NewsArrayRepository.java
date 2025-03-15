package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.dataSource.DataSource;
import com.mjc.school.repository.domain.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsArrayRepository implements BaseRepository<Long, News> {
    //
    private final List<News> newsList;

    public NewsArrayRepository() {
        //
        this.newsList = new ArrayList<>(DataSource.getInstance().getNewsList());
    }

    @Override
    public News create(News news) {
        //
        newsList.add(news);
        return news;
    }

    @Override
    public List<News> getAll() {
        //
        return new ArrayList<>(newsList);
    }

    @Override
    public Optional<News> getById(Long id) {
        //
        return newsList.stream()
                .filter(news -> news.getId().equals(id))
                .findFirst();
    }

    @Override
    public News update(Long id, News updatedNews) {
        //
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getId().equals(id)) {
                newsList.set(i, updatedNews);
                return updatedNews;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        //
        return newsList.removeIf(news -> news.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        //
        return newsList.stream()
                .anyMatch(news -> news.getId().equals(id));
    }

}
