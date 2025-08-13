package entity.session.individualSession;

import entity.participant.abstractParticipant.Participant;
import entity.participant.student.Student;
import entity.session.abstractSession.Session;
import entity.session.individualSession.individualSessionEnum.SessionAssistance;
import entity.session.individualSession.individualSessionEnum.SessionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "individual_session")
@Getter
@Setter
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
    private Set<Participant> relatedPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "assistance" , nullable = false)
    private SessionAssistance assistance;

    @Enumerated(EnumType.STRING)
    @Column(name = "session_type" , nullable = false)
    private SessionType type;
}
