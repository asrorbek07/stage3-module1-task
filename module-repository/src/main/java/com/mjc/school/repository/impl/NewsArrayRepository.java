package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.dataSource.DataSource;
import com.mjc.school.repository.domain.NewsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsArrayRepository implements BaseRepository<Long, NewsModel> {
    //
    private final DataSource dataSource;

    public NewsArrayRepository() {
        //
        this.dataSource = DataSource.getInstance();
    }

    @Override
    public NewsModel create(NewsModel newsModel) {
        //
        dataSource.getNewsModelList().add(newsModel);
        return newsModel;
    }

    @Override
    public List<NewsModel> readAll() {
        //
        return new ArrayList<>(dataSource.getNewsModelList());
    }

    @Override
    public Optional<NewsModel> readById(Long id) {
        //
        return dataSource.getNewsModelList().stream()
                .filter(news -> news.getId().equals(id))
                .findFirst();
    }

    @Override
    public NewsModel update(Long id, NewsModel updatedNewsModel) {
        //
        for (int i = 0; i < dataSource.getNewsModelList().size(); i++) {
            if (dataSource.getNewsModelList().get(i).getId().equals(id)) {
                dataSource.getNewsModelList().set(i, updatedNewsModel);
                return updatedNewsModel;
            }
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        //
        return dataSource.getNewsModelList().removeIf(news -> news.getId().equals(id));
    }

    @Override
    public Boolean existsById(Long id) {
        //
        return dataSource.getNewsModelList().stream()
                .anyMatch(news -> news.getId().equals(id));
    }

}
