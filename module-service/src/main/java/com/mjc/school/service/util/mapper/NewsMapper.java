package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "createdDate", target = "createDate")
    NewsDto toRdo(NewsModel newsModel);

    NewsModel toModel(NewsDto newsDto);
}
