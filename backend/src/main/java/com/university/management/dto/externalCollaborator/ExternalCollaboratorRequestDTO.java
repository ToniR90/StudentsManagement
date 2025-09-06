package com.university.management.dto.externalCollaborator;

import com.university.management.dto.participant.ParticipantRequestDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExternalCollaboratorRequestDTO extends ParticipantRequestDTO {

    @NotNull(message = "Affiliated company is required")
    private String affiliatedCompany;
}
