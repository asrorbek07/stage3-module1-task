package com.mjc.school.service.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsRequestDto {
    //
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
