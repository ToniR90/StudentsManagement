package com.university.management.entity.session.individualSession;

import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.abstractSession.Session;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "individual_session")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class IndividualSession extends Session {

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @Size(max = 1000)
    @Column(name = "commitment")
    private String commitment;

    @ManyToMany
    @JoinTable(
            name = "individual_session_related_people",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    @OrderBy("surname ASC , name ASC")
    private Set<Participant> relatedPeople;

    @NotNull(message = "Session assistance status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "assistance" , nullable = false)
    private SessionAssistance assistance;

    @NotNull(message = "Session type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "session_type" , nullable = false)
    private SessionType type;
}
