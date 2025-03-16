package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.repository.factory.RepositoryFactory;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.exception.ExceptionMessage;
import com.mjc.school.service.exception.ResourceNotFoundException;
import com.mjc.school.repository.domain.AuthorModel;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;
import com.mjc.school.service.util.mapper.NewsMapper;
import com.mjc.school.service.util.validator.NewsValidator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class NewsServiceLogic implements NewsService<Long, NewsCdo, NewsRdo> {
    private final BaseRepository<Long, NewsModel> newsRepository;
    private final BaseRepository<Long, AuthorModel> authorRepository;
    private final NewsMapper newsMapper;
    private final NewsValidator newsValidator;

    public NewsServiceLogic() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
        this.authorRepository = RepositoryFactory.getInstance().getAuthorRepository();
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsValidator = NewsValidator.getInstance();
    }

    @Override
    public NewsRdo create(NewsCdo newsCdo) {
        newsValidator.validateNewsDto(newsCdo);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        NewsModel newsModel = newsMapper.toModel(newsCdo);
        newsModel.setCreatedDate(now);
        newsModel.setLastUpdatedDate(now);
        NewsModel savedNewsModel = newsRepository.create(newsModel);
        return newsMapper.toRdo(savedNewsModel);
    }

    @Override
    public List<NewsRdo> readAll() {
        return newsRepository.readAll().stream()
                .map(newsMapper::toRdo)
                .collect(Collectors.toList());
    }

    @Override
    public NewsRdo readById(Long id) {
        newsValidator.validateNewsId(id);
        NewsModel newsModel = newsRepository.readById(id);
        if (newsModel==null){
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        return newsMapper.toRdo(newsModel);
    }

    @Override
    public NewsRdo update(NewsCdo newsCdo) {
        newsValidator.validateNewsId(newsCdo.getId());
        newsValidator.validateNewsDto(newsCdo);
        NewsModel newsModel = newsRepository.readById(newsCdo.getId());
        if (!authorRepository.existsById(newsCdo.getAuthorId())) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.AUTHOR_ID_DOES_NOT_EXIST), newsCdo.getAuthorId()));
        }
        if (newsModel==null) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), newsCdo.getId()));
        }
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        newsModel.setContent(newsCdo.getContent());
        newsModel.setTitle(newsCdo.getTitle());
        newsModel.setAuthorId(newsCdo.getAuthorId());
        newsModel.setLastUpdatedDate(now);
        NewsModel updatedNewsModel = newsRepository.update(newsModel);
        return newsMapper.toRdo(updatedNewsModel);
    }

    @Override
    public Boolean delete(Long id) {
        newsValidator.validateNewsId(id);
        if (!newsRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        return newsRepository.delete(id);
    }
}
