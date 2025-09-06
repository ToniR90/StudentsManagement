package com.university.management.repository;

import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.IndividualSession;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndividualSessionRepository extends JpaRepository<IndividualSession , Long> {

    List<IndividualSession> findBySessionAssistance(SessionAssistance assistance);
    List<IndividualSession> findBySessionType(SessionType type);
    List<IndividualSession> findByStudent(Student student);
}