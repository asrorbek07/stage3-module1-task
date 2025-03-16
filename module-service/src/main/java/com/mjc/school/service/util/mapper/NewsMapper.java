package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsRequestDto;
import com.mjc.school.service.model.dto.NewsResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "createdDate", target = "createDate")
    NewsResponseDto toRdo(NewsModel newsModel);
    NewsModel toModel(NewsRequestDto newsRequestDto);
}
