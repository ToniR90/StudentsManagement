package repository;

import entity.participant.abstractParticipant.Participant;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant , Long> {

    List<Participant> findByNameIgnoreCase(String name);
    List<Participant> findBySurnameIgnoreCase(String surname);
    Optional<Participant> findByEmailIgnoreCase(String email);
    List<Participant> findAllByRGPDStatus(RGPD_Status rgpdStatus);
    List<Participant> findAllBySessionList_Id(@Param("sessionId") Long sessionId);

}
