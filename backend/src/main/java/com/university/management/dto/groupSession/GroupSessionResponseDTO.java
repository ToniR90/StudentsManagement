package com.university.management.dto.groupSession;

import com.university.management.dto.session.SessionResponseDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class GroupSessionResponseDTO extends SessionResponseDTO {
    private Set<Participant> assistants;
    private Set<Participant> collaborators;
    private String classroom;
    private List<String> material;
    private String classTicket;
}
