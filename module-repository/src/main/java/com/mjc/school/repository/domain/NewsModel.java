package com.mjc.school.repository.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewsModel {
    //
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdatedDate;
    private Long authorId;
}
