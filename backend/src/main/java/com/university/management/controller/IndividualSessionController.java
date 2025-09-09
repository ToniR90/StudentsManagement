package com.university.management.controller;

import com.university.management.dto.individualSession.IndividualSessionRequestDTO;
import com.university.management.dto.individualSession.IndividualSessionResponseDTO;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionAssistance;
import com.university.management.entity.session.individualSession.individualSessionEnum.SessionType;
import com.university.management.service.IndividualSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("individual-session")
@RequiredArgsConstructor
public class IndividualSessionController {

    private final IndividualSessionService individualSessionService;

    @PostMapping
    public ResponseEntity<IndividualSessionResponseDTO> createIndividualSession(@Valid @RequestParam IndividualSessionRequestDTO individualSessionRequest) {
        IndividualSessionResponseDTO individualSessionResponse = individualSessionService.saveIndividualSession(individualSessionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(individualSessionResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<IndividualSessionResponseDTO>> getAllIndividualSessions() {
        List<IndividualSessionResponseDTO> responseList = individualSessionService.findAllIndividualSessions();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-student")
    public ResponseEntity<List<IndividualSessionResponseDTO>> getByStudent(Student student) {
        List<IndividualSessionResponseDTO> responseList = individualSessionService.findByStudent(student);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-assistance")
    public ResponseEntity<List<IndividualSessionResponseDTO>> getByAssistance(SessionAssistance assistance) {
        List<IndividualSessionResponseDTO> responseList = individualSessionService.findBySessionAssistance(assistance);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-session-type")
    public ResponseEntity<List<IndividualSessionResponseDTO>> getBySessionType(SessionType sessionType) {
        List<IndividualSessionResponseDTO> responseList = individualSessionService.findBySessionType(sessionType);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllIndividualSessions() {
        Long count = individualSessionService.countAllIndividualSessions();
        return ResponseEntity.ok(count);
    }
}