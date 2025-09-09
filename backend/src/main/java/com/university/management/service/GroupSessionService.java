package com.university.management.service;

import com.university.management.dto.groupSession.GroupSessionRequestDTO;
import com.university.management.dto.groupSession.GroupSessionResponseDTO;
import com.university.management.entity.session.groupSession.GroupSession;
import com.university.management.exception.personalException.GroupSessionNotFoundException;
import com.university.management.mapper.GroupSessionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.GroupSessionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GroupSessionService {

    private final GroupSessionRepository groupSessionRepository;

    public GroupSessionResponseDTO saveGroupSession(GroupSessionRequestDTO groupSessionRequest) {
        GroupSession groupSession = GroupSessionMapper.toEntity(groupSessionRequest);
        GroupSession savedGroupSession = groupSessionRepository.save(groupSession);
        return GroupSessionMapper.toResponse(savedGroupSession);
    }

    public List<GroupSessionResponseDTO> findByClassroom(String classroom) {
        List<GroupSession> sessions = groupSessionRepository.findByClassroomIgnoreCase(classroom);
        validateNotEmpty(sessions , "There are no sessions for the classroom: " + classroom);
        return sessions.stream()
                .map(GroupSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<GroupSessionResponseDTO> findByClassTicket(String classTicket) {
        List<GroupSession> sessions = groupSessionRepository.findByClassTicketIgnoreCase(classTicket);
        validateNotEmpty(sessions , "There are no sessions for the class ticket: " + classTicket);
        return sessions.stream()
                .map(GroupSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<GroupSessionResponseDTO> findAllGroupSessions() {
        List<GroupSession> sessions = groupSessionRepository.findAll();
        validateNotEmpty(sessions , "There are no group sessions");
        return sessions.stream()
                .map(GroupSessionMapper::toResponse)
                .collect(Collectors.toList());
    }

    public long countAllGroupSessions() {
        return groupSessionRepository.count();
    }

    public void validateNotEmpty(List<?> list , String message) {
        if(list.isEmpty()) {
            throw new GroupSessionNotFoundException(message);
        }
    }
}
