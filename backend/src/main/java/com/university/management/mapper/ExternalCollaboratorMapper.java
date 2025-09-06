package com.university.management.mapper;

import com.university.management.dto.externalCollaborator.ExternalCollaboratorRequestDTO;
import com.university.management.dto.externalCollaborator.ExternalCollaboratorResponseDTO;
import com.university.management.entity.participant.externalCollaborator.ExternalCollaborator;

public class ExternalCollaboratorMapper {

    public static ExternalCollaborator toEntity(ExternalCollaboratorRequestDTO dto) {
        return ExternalCollaborator.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .secondSurname(dto.getSecondSurname())
                .email(dto.getEmail())
                .rgpdStatus(dto.getRgpdStatus())
                .extraEmails(dto.getExtraEmails())
                .affiliatedCompany(dto.getAffiliatedCompany())
                .build();
    }

    public static ExternalCollaboratorResponseDTO toResponse(ExternalCollaborator externalCollaborator) {
        return ExternalCollaboratorResponseDTO.builder()
                .id(externalCollaborator.getId())
                .name(externalCollaborator.getName())
                .surname(externalCollaborator.getSurname())
                .secondSurname(externalCollaborator.getSecondSurname())
                .email(externalCollaborator.getEmail())
                .rgpdStatus(externalCollaborator.getRgpdStatus())
                .extraEmails(externalCollaborator.getExtraEmails())
                .affiliatedCompany(externalCollaborator.getAffiliatedCompany())
                .build();
    }
}
