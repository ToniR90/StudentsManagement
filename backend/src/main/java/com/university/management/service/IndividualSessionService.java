package com.university.management.service;

import com.university.management.dto.individualSession.IndividualSessionRequestDTO;
import com.university.management.dto.individualSession.IndividualSessionResponseDTO;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.IndividualSession;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import com.university.management.exception.personalException.IndividualSessionNotFoundException;
import com.university.management.mapper.IndividualSessionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.IndividualSessionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IndividualSessionService {     //Afegir el mapeig aquí

    private final IndividualSessionRepository individualSessionRepository;

    public IndividualSessionResponseDTO saveIndividualSession(IndividualSessionRequestDTO individualSessionRequest) {
        IndividualSession individualSession = IndividualSessionMapper.toEntity(individualSessionRequest);
        IndividualSession savedIndividualSession = individualSessionRepository.save(individualSession);
        return IndividualSessionMapper.toResponse(savedIndividualSession);
    }

    public List<IndividualSessionResponseDTO> findAllIndividualSessions() {
        List<IndividualSession> sessions = individualSessionRepository.findAll();
        validateNotEmpty(sessions , "There are no sessions");
        return sessions.stream()
                .map(IndividualSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<IndividualSessionResponseDTO> findByStudent(Student student) {
        List<IndividualSession> sessions = individualSessionRepository.findByStudent(student);
        validateNotEmpty(sessions , "There are no sessions for the student " + student.getName());
        return sessions.stream()
                .map(IndividualSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<IndividualSessionResponseDTO> findBySessionAssistance(SessionAssistance assistance) {
        List<IndividualSession> sessions = individualSessionRepository.findBySessionAssistance(assistance);
        validateNotEmpty(sessions , "There are no sessions with assistance: " + assistance.getLabel());
        return sessions.stream()
                .map(IndividualSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<IndividualSessionResponseDTO> findBySessionType(SessionType sessionType) {
        List<IndividualSession> sessions = individualSessionRepository.findBySessionType(sessionType);
        validateNotEmpty(sessions , "There are no sessions for the type: " + sessionType.getLabel());
        return sessions.stream()
                .map(IndividualSessionMapper::toResponse)
                .collect(Collectors.toList());
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
