package com.university.management.controller;

import com.university.management.dto.session.SessionResponseDTO;
import com.university.management.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/all")
    public ResponseEntity<List<SessionResponseDTO>> getAllSessions() {
        List<SessionResponseDTO> sessions = sessionService.findAllSessions();
        return ResponseEntity.ok(sessions);
    }

    @DeleteMapping("/by-id")
    public ResponseEntity<SessionResponseDTO> deleteById(@RequestParam Long id) {
        SessionResponseDTO session = sessionService.deleteSession(id);
        return ResponseEntity.ok(session);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        Long count = sessionService.countAllSessions();
        return ResponseEntity.ok(count);
    }
}
