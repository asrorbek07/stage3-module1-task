package com.mjc.school.repository.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorModel {
    //
    private Long id;
    private String name;
}
