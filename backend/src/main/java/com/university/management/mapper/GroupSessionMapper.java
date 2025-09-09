package com.university.management.mapper;

import com.university.management.dto.groupSession.GroupSessionRequestDTO;
import com.university.management.dto.groupSession.GroupSessionResponseDTO;
import com.university.management.entity.session.groupSession.GroupSession;

public class GroupSessionMapper {
    public static GroupSession toEntity(GroupSessionRequestDTO dto) {
        return GroupSession.builder()
                .date(dto.getDate())
                .summary(dto.getSummary())
                .assistants(dto.getAssistants())
                .collaborators(dto.getCollaborators())
                .classroom(dto.getClassroom())
                .material(dto.getMaterial())
                .classTicket(dto.getClassTicket())
                .build();
    }

    public static GroupSessionResponseDTO toResponse(GroupSession groupSession) {
        return GroupSessionResponseDTO.builder()
                .id(groupSession.getId())
                .date(groupSession.getDate())
                .summary(groupSession.getSummary())
                .createdAt(groupSession.getCreatedAt())
                .updatedAt(groupSession.getUpdatedAt())
                .assistants(groupSession.getAssistants())
                .collaborators(groupSession.getCollaborators())
                .classroom(groupSession.getClassroom())
                .material(groupSession.getMaterial())
                .classTicket(groupSession.getClassTicket())
                .build();
    }
}