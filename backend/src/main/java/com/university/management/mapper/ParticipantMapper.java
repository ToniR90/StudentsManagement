package com.university.management.mapper;

import com.university.management.dto.participant.ParticipantResponseDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;

public class ParticipantMapper {

    public static ParticipantResponseDTO toResponse(Participant participant) {
        return ParticipantResponseDTO.builder()
                .id(participant.getId())
                .name(participant.getName())
                .surname(participant.getSurname())
                .secondSurname(participant.getSecondSurname())
                .email(participant.getEmail())
                .extraEmails(participant.getExtraEmails())
                .rgpdStatus(participant.getRgpdStatus())
                .build();

    }
}
