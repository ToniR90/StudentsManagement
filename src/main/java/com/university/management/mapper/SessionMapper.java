package com.university.management.mapper;

import com.university.management.dto.session.SessionRequestDTO;
import com.university.management.entity.session.abstractSession.Session;

public class SessionMapper {

    public static Session toEntity(SessionRequestDTO dto) {
        return Session.builder()
                .date(dto.getDate())
                .summary(dto.getSummary())
                .build();
    }

    public static SessionRequestDTO toDTO(Session session) {
        return new SessionRequestDTO(
                session.getDate(),
                session.getSummary()
        );
    }
}