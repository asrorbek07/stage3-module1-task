package com.mjc.school.service.util.mapper;

import com.mjc.school.repository.domain.NewsModel;
import com.mjc.school.service.model.dto.NewsCdo;
import com.mjc.school.service.model.dto.NewsRdo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);

    @Mapping(source = "createdDate", target = "createDate")
    NewsRdo toRdo(NewsModel newsModel);
    NewsModel toModel(NewsCdo newsCdo);
}
