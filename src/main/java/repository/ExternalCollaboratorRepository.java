package repository;

import entity.participant.externalCollaborator.ExternalCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalCollaboratorRepository extends JpaRepository<ExternalCollaborator, Long> {
}
