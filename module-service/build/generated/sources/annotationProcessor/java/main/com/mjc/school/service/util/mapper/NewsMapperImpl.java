package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsDtoRequest;
import com.mjc.school.service.model.dto.NewsDtoResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T14:53:25+0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17.0.14 (Amazon.com Inc.)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDtoResponse toRdo(NewsModel newsModel) {
        if ( newsModel == null ) {
            return null;
        }

        NewsDtoResponse.NewsDtoResponseBuilder newsDtoResponse = NewsDtoResponse.builder();

        newsDtoResponse.createDate( newsModel.getCreatedDate() );
        newsDtoResponse.id( newsModel.getId() );
        newsDtoResponse.title( newsModel.getTitle() );
        newsDtoResponse.content( newsModel.getContent() );
        newsDtoResponse.lastUpdatedDate( newsModel.getLastUpdatedDate() );
        newsDtoResponse.authorId( newsModel.getAuthorId() );

        return newsDtoResponse.build();
    }

    @Override
    public NewsModel toModel(NewsDtoRequest newsDtoRequest) {
        if ( newsDtoRequest == null ) {
            return null;
        }

        NewsModel.NewsModelBuilder newsModel = NewsModel.builder();

        newsModel.id( newsDtoRequest.getId() );
        newsModel.title( newsDtoRequest.getTitle() );
        newsModel.content( newsDtoRequest.getContent() );
        newsModel.authorId( newsDtoRequest.getAuthorId() );

        return newsModel.build();
    }
}
