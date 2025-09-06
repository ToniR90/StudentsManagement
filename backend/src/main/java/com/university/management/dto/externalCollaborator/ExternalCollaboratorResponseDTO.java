package com.university.management.dto.externalCollaborator;

import com.university.management.dto.participant.ParticipantResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ExternalCollaboratorResponseDTO extends ParticipantResponseDTO {
    private String affiliatedCompany;
}
