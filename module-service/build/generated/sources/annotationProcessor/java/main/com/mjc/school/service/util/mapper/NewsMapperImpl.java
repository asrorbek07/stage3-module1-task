package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T20:55:26+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto toRdo(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDto.NewsDtoBuilder newsDto = NewsDto.builder();

        newsDto.id( newsModel.getId() );
        newsDto.title( newsModel.getTitle() );
        newsDto.content( newsModel.getContent() );
        newsDto.createdDate( newsModel.getCreatedDate() );
        newsDto.lastUpdatedDate( newsModel.getLastUpdatedDate() );
        newsDto.authorId( newsModel.getAuthorId() );

        return newsDto.build();
    }

    @Override
    public NewsModel toModel(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        NewsModel.NewsModelBuilder newsModel = NewsModel.builder();

        newsModel.id( newsDto.getId() );
        newsModel.title( newsDto.getTitle() );
        newsModel.content( newsDto.getContent() );
        newsModel.createdDate( newsDto.getCreatedDate() );
        newsModel.lastUpdatedDate( newsDto.getLastUpdatedDate() );
        newsModel.authorId( newsDto.getAuthorId() );

        return newsModel.build();
    }
}
