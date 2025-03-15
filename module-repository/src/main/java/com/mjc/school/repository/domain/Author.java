package com.mjc.school.repository.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class Author {
    //
    private Long id;
    private String name;
}
