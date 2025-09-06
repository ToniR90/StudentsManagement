package com.university.management.service;

import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.IndividualSession;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import com.university.management.exception.personalException.IndividualSessionNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.IndividualSessionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualSessionService {

    private final IndividualSessionRepository individualSessionRepository;

    public IndividualSession saveIndividualSession(IndividualSession individualSession) {
        return individualSessionRepository.save(individualSession);
    }

    public void deleteIndividualSession(Long id) {
        IndividualSession individualSession = individualSessionRepository.findById(id)
                .orElseThrow(() -> new IndividualSessionNotFoundException("There's no session with id: " + id));
        individualSessionRepository.delete(individualSession);
    }

    public List<IndividualSession> findAllIndividualSessions() {
        List<IndividualSession> sessions = individualSessionRepository.findAll();
        validateNotEmpty(sessions , "There are no sessions");
        return sessions;
    }

    public List<IndividualSession> findByStudent(Student student) {
        List<IndividualSession> sessions = individualSessionRepository.findByStudent(student);
        validateNotEmpty(sessions , "There are no sessions for the student " + student.getName());
        return sessions;
    }

    public List<IndividualSession> findBySessionAssistance(SessionAssistance assistance) {
        List<IndividualSession> sessions = individualSessionRepository.findBySessionAssistance(assistance);
        validateNotEmpty(sessions , "There are no sessions with assistance: " + assistance.getLabel());
        return sessions;
    }

    public List<IndividualSession> findBySessionType(SessionType sessionType) {
        List<IndividualSession> sessions = individualSessionRepository.findBySessionType(sessionType);
        validateNotEmpty(sessions , "There are no sessions for the type: " + sessionType.getLabel());
        return sessions;
    }

    public Long countAllIndividualSessions() {
        return individualSessionRepository.count();
    }

    public void validateNotEmpty(List<?> list, String message) {
        if(list.isEmpty()) {
            throw new IndividualSessionNotFoundException(message);
        }
    }
}
