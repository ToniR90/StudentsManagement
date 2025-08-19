package controller;

import dto.participant.ParticipantResponseDTO;
import entity.participant.abstractParticipant.Participant;
import lombok.RequiredArgsConstructor;
import mapper.ParticipantMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ParticipantService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/all")
    public ResponseEntity<List<ParticipantResponseDTO>> getAll() {
        List<Participant> participants = participantService.findAllParticipants();
        List<ParticipantResponseDTO> responseList = participants
                .stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
    @GetMapping("/by-name")
    public ResponseEntity<List<ParticipantResponseDTO>> getByName(@RequestParam String name) {
        List<Participant> participants = participantService.findByNameIgnoreCase(name.trim());
        List<ParticipantResponseDTO> responseList = participants
                .stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("by-surname")
    public ResponseEntity<List<ParticipantResponseDTO>> getBySurname(@RequestParam String surname) {
        List<Participant> participants = participantService.findBySurnameIgnoreCase(surname.trim());
        List<ParticipantResponseDTO> responseList = participants
                .stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-email")
    public ResponseEntity<ParticipantResponseDTO> getByEmail(@RequestParam String email) {
        Participant participant = participantService.findByEmailIgnoreCase(email);
        return ResponseEntity.ok(ParticipantMapper.toResponse(participant));
    }

    @GetMapping("/by-rgpd-status")
    public ResponseEntity<List<ParticipantResponseDTO>> getByRgpdStatus(@RequestParam String status) {
        List<Participant> participants = participantService.findByRGPDStatus(status);
        List<ParticipantResponseDTO> responseList = participants
                .stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-session")
    public ResponseEntity<List<ParticipantResponseDTO>> getBySession(@RequestParam String session) {
        List<Participant> participants = participantService.findAllBySessionIgnoreCase(session);
        List<ParticipantResponseDTO> responseList = participants
                .stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

}