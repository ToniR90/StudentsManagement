package repository;

import entity.session.individualSession.IndividualSession;
import entity.session.individualSession.individualSessionEnum.SessionAssistance;
import entity.session.individualSession.individualSessionEnum.SessionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndividualSessionRepository extends JpaRepository<IndividualSession , Long> {

    List<IndividualSession> findBySessionAssistance(SessionAssistance assistance);
    List<IndividualSession> findBySessionType(SessionType type);
}