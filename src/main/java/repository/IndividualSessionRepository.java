package repository;

import entity.session.individualSession.IndividualSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividualSessionRepository extends JpaRepository<IndividualSession , Long> {
}
