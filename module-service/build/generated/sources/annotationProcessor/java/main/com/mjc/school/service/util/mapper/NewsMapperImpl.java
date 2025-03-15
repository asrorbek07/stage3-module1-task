package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.News;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-15T16:12:40+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsRdo toRdo(News news) {
        if ( news == null ) {
            return null;
        }

        LocalDateTime createDate = null;
        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime lastUpdatedDate = null;
        Long authorId = null;

        createDate = news.getCreatedDate();
        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        lastUpdatedDate = news.getLastUpdatedDate();
        authorId = news.getAuthorId();

        NewsRdo newsRdo = new NewsRdo( id, title, content, createDate, lastUpdatedDate, authorId );

        return newsRdo;
    }

    @Override
    public News toDomain(NewsCdo newsCdo) {
        if ( newsCdo == null ) {
            return null;
        }

        News.NewsBuilder news = News.builder();

        news.title( newsCdo.getTitle() );
        news.content( newsCdo.getContent() );
        news.authorId( newsCdo.getAuthorId() );

        return news.build();
    }
}
