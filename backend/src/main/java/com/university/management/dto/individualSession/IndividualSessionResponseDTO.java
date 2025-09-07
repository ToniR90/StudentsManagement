package com.university.management.dto.individualSession;

import com.university.management.dto.session.SessionResponseDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class IndividualSessionResponseDTO extends SessionResponseDTO {
    private Student student;
    private String commitment;
    private Set<Participant> relatedPeople;
    private SessionAssistance assistance;
    private SessionType sessionType;
}
