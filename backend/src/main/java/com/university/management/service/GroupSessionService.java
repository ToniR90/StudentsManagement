package com.university.management.service;

import com.university.management.dto.groupSession.GroupSessionResponseDTO;
import com.university.management.entity.session.groupSession.GroupSession;
import com.university.management.exception.personalException.GroupSessionNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.GroupSessionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupSessionService {

    private final GroupSessionRepository groupSessionRepository;

    public GroupSessionResponseDTO saveGroupSession(GroupSession groupSession) {
        return groupSessionRepository.save(groupSession);
    }

    public void deleteGroupSession(Long id) {
        GroupSession groupSession = groupSessionRepository.findById(id)
                .orElseThrow(() -> new GroupSessionNotFoundException("There are no group sessions with id: " + id));
        groupSessionRepository.delete(groupSession);
    }

    public long countAllGroupSessions() {
        return groupSessionRepository.count();
    }

    public List<GroupSession> findByClassroom(String classroom) {
        List<GroupSession> sessions = groupSessionRepository.findByClassroomIgnoreCase(classroom);
        validateNotEmpty(sessions , "There are no sessions for the classroom: " + classroom);
        return sessions;
    }

    public List<GroupSession> findByClassTicket(String classTicket) {
        List<GroupSession> sessions = groupSessionRepository.findByClassTicketIgnoreCase(classTicket);
        validateNotEmpty(sessions , "There are no sessions for the class ticket: " + classTicket);
        return sessions;
    }

    public List<GroupSession> findAllGroupSessions() {
        List<GroupSession> sessions = groupSessionRepository.findAll();
        validateNotEmpty(sessions , "There are no group sessions");
        return sessions;
    }

    public void validateNotEmpty(List<?> list , String message) {
        if(list.isEmpty()) {
            throw new GroupSessionNotFoundException(message);
        }
    }
}
