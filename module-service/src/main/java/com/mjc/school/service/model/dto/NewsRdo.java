package com.mjc.school.service.model.dto;

import java.time.LocalDateTime;

public record NewsRdo(Long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdatedDate, Long authorId) {
}
