package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsRequestDto;
import com.mjc.school.service.model.dto.NewsResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T14:48:13+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsResponseDto toRdo(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsResponseDto.NewsResponseDtoBuilder newsResponseDto = NewsResponseDto.builder();

        newsResponseDto.createDate( newsModel.getCreatedDate() );
        newsResponseDto.id( newsModel.getId() );
        newsResponseDto.title( newsModel.getTitle() );
        newsResponseDto.content( newsModel.getContent() );
        newsResponseDto.lastUpdatedDate( newsModel.getLastUpdatedDate() );
        newsResponseDto.authorId( newsModel.getAuthorId() );

        return newsResponseDto.build();
    }

    @Override
    public NewsModel toModel(NewsRequestDto newsRequestDto) {
        if ( newsRequestDto == null ) {
            return null;
        }

        NewsModel.NewsModelBuilder newsModel = NewsModel.builder();

        newsModel.id( newsRequestDto.getId() );
        newsModel.title( newsRequestDto.getTitle() );
        newsModel.content( newsRequestDto.getContent() );
        newsModel.authorId( newsRequestDto.getAuthorId() );

        return newsModel.build();
    }
}
