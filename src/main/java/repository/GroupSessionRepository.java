package repository;

import entity.session.groupSession.GroupSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupSessionRepository extends JpaRepository<GroupSession , Long> {
}
