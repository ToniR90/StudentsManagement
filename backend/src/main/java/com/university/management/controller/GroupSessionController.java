package com.university.management.controller;

import com.university.management.dto.groupSession.GroupSessionRequestDTO;
import com.university.management.dto.groupSession.GroupSessionResponseDTO;
import com.university.management.service.GroupSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group-session")
@RequiredArgsConstructor
public class GroupSessionController {

    private final GroupSessionService groupSessionService;

    @PostMapping
    public ResponseEntity<GroupSessionResponseDTO> createGroupSession(@Valid @RequestParam GroupSessionRequestDTO groupSessionRequest) {
        GroupSessionResponseDTO groupSession = groupSessionService.saveGroupSession(groupSessionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(groupSession);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupSessionResponseDTO>> getAllGroupSessions() {
        List<GroupSessionResponseDTO> responseList = groupSessionService.findAllGroupSessions();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-classroom")
    public ResponseEntity<List<GroupSessionResponseDTO>> getByClassroom(String classroom) {
        List<GroupSessionResponseDTO> responseList = groupSessionService.findByClassroom(classroom);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-class-ticket")
    public ResponseEntity<List<GroupSessionResponseDTO>> getByClassTicket(String classTicket) {
        List<GroupSessionResponseDTO> responseList = groupSessionService.findByClassTicket(classTicket);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllGroupSessions() {
        Long count = groupSessionService.countAllGroupSessions();
        return ResponseEntity.ok(count);
    }
}
