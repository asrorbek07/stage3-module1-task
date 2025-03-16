package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.repository.factory.RepositoryFactory;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.exception.ExceptionMessage;
import com.mjc.school.service.exception.ResourceNotFoundException;
import com.mjc.school.service.model.dto.NewsDtoRequest;
import com.mjc.school.service.model.dto.NewsDtoResponse;
import com.mjc.school.service.util.mapper.NewsMapper;
import com.mjc.school.service.util.validator.NewsValidator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class NewsServiceLogic implements NewsService<Long, NewsDtoRequest, NewsDtoResponse> {
    private final BaseRepository<Long, NewsModel> newsRepository;
    private final NewsMapper newsMapper;
    private final NewsValidator newsValidator;

    public NewsServiceLogic() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsValidator = NewsValidator.getInstance();
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest newsDtoRequest) {
        newsValidator.validateNewsDto(newsDtoRequest);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        NewsModel newsModel = newsMapper.toModel(newsDtoRequest);
        newsModel.setCreatedDate(now);
        newsModel.setLastUpdatedDate(now);
        NewsModel savedNewsModel = newsRepository.create(newsModel);
        return newsMapper.toRdo(savedNewsModel);
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return newsRepository.readAll().stream()
                .map(newsMapper::toRdo)
                .collect(Collectors.toList());
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        newsValidator.validateNewsId(id);
        NewsModel newsModel = newsRepository.readById(id);
        if (newsModel==null){
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        return newsMapper.toRdo(newsModel);
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest newsDtoRequest) {
        newsValidator.validateNewsId(newsDtoRequest.getId());
        newsValidator.validateNewsDto(newsDtoRequest);
        NewsModel newsModel = newsRepository.readById(newsDtoRequest.getId());
        if (newsModel==null) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), newsDtoRequest.getId()));
        }
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        newsModel.setContent(newsDtoRequest.getContent());
        newsModel.setTitle(newsDtoRequest.getTitle());
        newsModel.setAuthorId(newsDtoRequest.getAuthorId());
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
