package com.mjc.school.service.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class NewsCdo {
    //
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
