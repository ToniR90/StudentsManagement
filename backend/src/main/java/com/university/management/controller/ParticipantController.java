package com.university.management.controller;

import com.university.management.dto.participant.ParticipantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.university.management.service.ParticipantService;

import java.util.List;

@RestController
@RequestMapping("participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/all")
    public ResponseEntity<List<ParticipantResponseDTO>> getAll() {
        List<ParticipantResponseDTO> responseList = participantService
                .findAllParticipants();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<ParticipantResponseDTO>> getByName(@RequestParam String name) {
        List<ParticipantResponseDTO> responseList = participantService
                .findByNameIgnoreCase(name.trim());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-surname")
    public ResponseEntity<List<ParticipantResponseDTO>> getBySurname(@RequestParam String surname) {
        List<ParticipantResponseDTO> responseList = participantService
                .findBySurnameIgnoreCase(surname.trim());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-second-surname")
    public ResponseEntity<List<ParticipantResponseDTO>> getBySecondSurname(@RequestParam String secondSurname) {
        List<ParticipantResponseDTO> responseList = participantService
                .findBySecondSurnameIgnoreCase(secondSurname.trim());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-email")
    public ResponseEntity<ParticipantResponseDTO> getByEmail(@RequestParam String email) {
        ParticipantResponseDTO responseDTO = participantService
                .findByEmailIgnoreCase(email);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/by-rgpd-status")
    public ResponseEntity<List<ParticipantResponseDTO>> getByRgpdStatus(@RequestParam String status) {
        List<ParticipantResponseDTO> responseList = participantService
                .findAllByRGPDStatus(status);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-session")
    public ResponseEntity<List<ParticipantResponseDTO>> getBySession(@RequestParam Long sessionId) {
        List<ParticipantResponseDTO> responseList = participantService
                .findAllBySession(sessionId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/by-email")
    public ResponseEntity<ParticipantResponseDTO> deleteByEmail(@RequestParam String email) {
        ParticipantResponseDTO responseDTO = participantService
                .deleteByEmailIgnoreCase(email);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        Long count = participantService.countAllParticipants();
        return ResponseEntity.ok(count);
    }
}
