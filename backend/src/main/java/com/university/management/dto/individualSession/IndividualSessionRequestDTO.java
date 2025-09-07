package com.university.management.dto.individualSession;

import com.university.management.dto.session.SessionRequestDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IndividualSessionRequestDTO extends SessionRequestDTO {

    @NotNull(message = "Student is required")
    private Student student;

    @NotNull(message = "Commitment is required")
    private String commitment;

    private Set<Participant> relatedPeople;

    @NotNull(message = "Assistance is required")
    private SessionAssistance assistance;

    @NotNull(message = "Session type is required")
    private SessionType sessionType;
}
