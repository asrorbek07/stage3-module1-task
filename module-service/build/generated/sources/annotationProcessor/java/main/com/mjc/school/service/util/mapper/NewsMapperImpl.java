package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-15T16:43:46+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsRdo toRdo(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        LocalDateTime createDate = null;
        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime lastUpdatedDate = null;
        Long authorId = null;

        createDate = newsModel.getCreatedDate();
        id = newsModel.getId();
        title = newsModel.getTitle();
        content = newsModel.getContent();
        lastUpdatedDate = newsModel.getLastUpdatedDate();
        authorId = newsModel.getAuthorId();

        NewsRdo newsRdo = new NewsRdo( id, title, content, createDate, lastUpdatedDate, authorId );

        return newsRdo;
    }

    @Override
    public NewsModel toDomain(NewsCdo newsCdo) {
        if ( newsCdo == null ) {
            return null;
        }

        NewsModel.NewsModelBuilder newsModel = NewsModel.builder();

        newsModel.title( newsCdo.getTitle() );
        newsModel.content( newsCdo.getContent() );
        newsModel.authorId( newsCdo.getAuthorId() );

        return newsModel.build();
    }
}
