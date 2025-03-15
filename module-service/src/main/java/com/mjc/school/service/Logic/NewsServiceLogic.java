package com.mjc.school.service.Logic;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.factory.RepositoryFactory;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.exception.ExceptionMessage;
import com.mjc.school.service.exception.ResourceNotFoundException;
import com.mjc.school.repository.domain.Author;
import com.mjc.school.repository.domain.News;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;
import com.mjc.school.service.util.mapper.NewsMapper;
import com.mjc.school.service.util.validator.NewsValidator;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class NewsServiceLogic implements NewsService<Long, NewsCdo, NewsRdo> {
    private final BaseRepository<Long, News> newsRepository;
    private final BaseRepository<Long, Author> authorRepository;
    private final NewsMapper newsMapper;
    private final NewsValidator newsValidator;

    public NewsServiceLogic() {
        this.newsRepository = RepositoryFactory.getInstance().getNewsRepository();
        this.authorRepository = RepositoryFactory.getInstance().getAuthorRepository();
        this.newsMapper = NewsMapper.INSTANCE;
        this.newsValidator = NewsValidator.getInstance();
    }

    @Override
    public NewsRdo register(NewsCdo newsCdo) {
        newsValidator.validateNewsDto(newsCdo);
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        News news = newsMapper.toDomain(newsCdo);
        news.setCreatedDate(now);
        news.setLastUpdatedDate(now);
        News savedNews = newsRepository.create(news);
        return newsMapper.toRdo(savedNews);
    }

    @Override
    public List<NewsRdo> findAll() {
        return newsRepository.getAll().stream()
                .map(newsMapper::toRdo)
                .collect(Collectors.toList());
    }

    @Override
    public NewsRdo findById(Long id) {
        newsValidator.validateNewsId(id);
        News news = newsRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id)));
        return newsMapper.toRdo(news);
    }

    @Override
    public NewsRdo modify(Long id, NewsCdo newsCdo) {
        newsValidator.validateNewsId(id);
        newsValidator.validateNewsDto(newsCdo);
        if (!newsRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        News news = newsMapper.toDomain(newsCdo);
        news.setId(id);
        news.setLastUpdatedDate(now);
        News updatedNews = newsRepository.update(news.getId(), news);
        return newsMapper.toRdo(updatedNews);
    }

    @Override
    public boolean remove(Long id) {
        newsValidator.validateNewsId(id);
        if (!newsRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(String.valueOf(ExceptionMessage.NEWS_ID_DOES_NOT_EXIST), id));
        }
        return newsRepository.delete(id);
    }
}
