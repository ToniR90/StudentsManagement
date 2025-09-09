package com.university.management.dto.groupSession;

import com.university.management.dto.session.SessionRequestDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class GroupSessionRequestDTO extends SessionRequestDTO {

    @NotNull(message = "Assistants is required")
    private Set<Participant> assistants;

    private Set<Participant> collaborators;

    @NotNull(message = "Classroom is required")
    private String classroom;

    private List<String> material;

    @NotNull(message = "Class Ticket is required")
    private String classTicket;
}
