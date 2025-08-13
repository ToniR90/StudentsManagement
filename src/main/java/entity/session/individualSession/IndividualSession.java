package entity.session.individualSession;

import entity.participant.abstractParticipant.Participant;
import entity.participant.student.Student;
import entity.session.abstractSession.Session;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IndividualSession extends Session {
    private Student student;
    private String commitment;
    private Set<Participant> relatedPeople;

}
