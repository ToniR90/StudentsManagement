package com.university.management.mapper;

import com.university.management.dto.session.SessionRequestDTO;
import com.university.management.dto.session.SessionResponseDTO;
import com.university.management.entity.session.abstractSession.Session;

public class SessionMapper {

    public static SessionResponseDTO toResponse(Session session) {
        return SessionResponseDTO.builder()
                .id(session.getId())
                .date(session.getDate())
                .summary(session.getSummary())
                .createdAt(session.getCreatedAt())
                .updatedAt(session.getUpdatedAt())
                .build();
    }
}