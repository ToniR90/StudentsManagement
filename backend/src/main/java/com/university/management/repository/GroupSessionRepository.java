package com.university.management.repository;

import com.university.management.entity.session.groupSession.GroupSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupSessionRepository extends JpaRepository<GroupSession , Long> {

    List<GroupSession> findByClassroomIgnoreCase(String classroom);
    List<GroupSession> findByClassTicketIgnoreCase(String classTicket);
}
