package com.university.management.service;

import com.university.management.dto.session.SessionResponseDTO;
import com.university.management.entity.session.abstractSession.Session;
import com.university.management.exception.personalException.SessionNotFoundException;
import com.university.management.mapper.SessionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.university.management.repository.SessionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionResponseDTO deleteSession(Long id) {
        Session session = sessionRepository.findById(id)
                .orElseThrow(() -> new SessionNotFoundException("Session with id " + id + " not found"));
        sessionRepository.delete(session);
        return SessionMapper.toResponse(session);
    }

    public List<Session> findAllSessions() {
        List<Session> sessions = sessionRepository.findAll();
        validateNotEmpty(sessions , "There are no sessions");
        return sessions;
    }

    public long countAllSessions() {
        return sessionRepository.count();
    }

    public void validateNotEmpty(List<?> list, String message) {
        if(list.isEmpty()) {
            throw new SessionNotFoundException(message);
        }
    }
}
