package com.university.management.dto.student;

import com.university.management.dto.participant.ParticipantResponseDTO;
import com.university.management.entity.participant.student.studentEnum.AlumniType;
import com.university.management.entity.participant.student.studentEnum.Degree;
import com.university.management.entity.participant.student.studentEnum.ServiceAwareness;
import com.university.management.entity.participant.student.studentEnum.StudyYear;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public class StudentResponseDTO extends ParticipantResponseDTO {
    private Degree degree;
    private StudyYear studyYear;
    private Boolean isAlumni;
    private AlumniType alumniType;
    private ServiceAwareness serviceAwareness;
    private String serviceAwarenessDisplayLabel;
    private LocalDate firstContactDate;
    private String personalObservation;
}