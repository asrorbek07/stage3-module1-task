package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.repository.factory.RepositoryFactory;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.exception.ExceptionMessage;
import com.mjc.school.service.exception.ResourceNotFoundException;
import com.mjc.school.service.model.dto.NewsRequestDto;
import com.mjc.school.service.model.dto.NewsResponseDto;
import com.mjc.school.service.util.mapper.NewsMapper;
import com.mjc.school.service.util.validator.NewsValidator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class NewsServiceLogic implements NewsService<Long, NewsRequestDto, NewsResponseDto> {
    private final BaseRepository<Long, NewsModel> newsRepository;
    private final NewsMapper newsMapper;
    private final NewsValidator newsValidator;

    public NewsServiceLogic() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsValidator = NewsValidator.getInstance();
    }

    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        newsValidator.validateNewsDto(newsRequestDto);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        NewsModel newsModel = newsMapper.toModel(newsRequestDto);
        newsModel.setCreatedDate(now);
        newsModel.setLastUpdatedDate(now);
        NewsModel savedNewsModel = newsRepository.create(newsModel);
        return newsMapper.toRdo(savedNewsModel);
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return newsRepository.readAll().stream()
                .map(newsMapper::toRdo)
                .collect(Collectors.toList());
    }

    @Override
    public NewsResponseDto readById(Long id) {
        newsValidator.validateNewsId(id);
        NewsModel newsModel = newsRepository.readById(id);
        if (newsModel==null){
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        return newsMapper.toRdo(newsModel);
    }

    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        newsValidator.validateNewsId(newsRequestDto.getId());
        newsValidator.validateNewsDto(newsRequestDto);
        NewsModel newsModel = newsRepository.readById(newsRequestDto.getId());
        if (newsModel==null) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), newsRequestDto.getId()));
        }
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        newsModel.setContent(newsRequestDto.getContent());
        newsModel.setTitle(newsRequestDto.getTitle());
        newsModel.setAuthorId(newsRequestDto.getAuthorId());
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
