package com.university.management.mapper;

import com.university.management.dto.individualSession.IndividualSessionRequestDTO;
import com.university.management.dto.individualSession.IndividualSessionResponseDTO;
import com.university.management.entity.session.individualSession.IndividualSession;

public class IndividualSessionMapper {
    public static IndividualSession toEntity(IndividualSessionRequestDTO dto) {
        return IndividualSession.builder()
                .date(dto.getDate())
                .summary(dto.getSummary())
                .student(dto.getStudent())
                .commitment(dto.getCommitment())
                .relatedPeople(dto.getRelatedPeople())
                .assistance(dto.getAssistance())
                .type(dto.getSessionType())
                .build();
    }

    public static IndividualSessionResponseDTO toResponse(IndividualSession individualSession) {
        return IndividualSessionResponseDTO.builder()
                .id(individualSession.getId())
                .date(individualSession.getDate())
                .summary((individualSession.getSummary()))
                .createdAt(individualSession.getCreatedAt())
                .updatedAt(individualSession.getUpdatedAt())
                .student(individualSession.getStudent())
                .commitment(individualSession.getCommitment())
                .relatedPeople(individualSession.getRelatedPeople())
                .assistance(individualSession.getAssistance())
                .type(individualSession.getType())
                .build();
    }
}
