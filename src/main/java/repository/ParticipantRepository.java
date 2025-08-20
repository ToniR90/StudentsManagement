package repository;

import entity.participant.abstractParticipant.Participant;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.session.abstractSession.Session;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends Repository<Participant , Long> {

    List<Participant> findAllParticipants();
    List<Participant> findByNameIgnoreCase(String name);
    List<Participant> findBySurnameIgnoreCase(String surname);
    Optional<Participant> findByEmailIgnoreCase(String email);
    List<Participant> findAllByRGPDStatus(RGPD_Status rgpdStatus);
    List<Participant> findAllBySession(@Param("sessionId") Long sessionId);
    //List<Participant> findAllByGroupSession(@Param("sessionId") Long sessionId);
    //List<Participant> findAllBySessionIgnoreCase(Session session);
}
