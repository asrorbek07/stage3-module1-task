package com.mjc.school.service.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class NewsDto {
    //
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private Long authorId;
}
