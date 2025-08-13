package entity.session.groupSession;

import entity.participant.abstractParticipant.Participant;
import entity.session.abstractSession.Session;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "group_session")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupSession extends Session {

    private Set<Participant> assistants;
    private Set<Participant> collaborators;
    private double assistance;
    private String classroom;
    private List<String> material;
    private String classTicket;
}
