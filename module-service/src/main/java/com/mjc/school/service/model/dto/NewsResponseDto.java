package com.mjc.school.service.model.dto;

import java.time.LocalDateTime;

public record NewsResponseDto(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Long authorId) {
}
