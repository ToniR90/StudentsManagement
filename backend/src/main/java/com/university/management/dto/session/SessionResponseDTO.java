package com.university.management.dto.session;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
public class SessionResponseDTO {
    private Long id;
    private LocalDate date;
    private String summary;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
