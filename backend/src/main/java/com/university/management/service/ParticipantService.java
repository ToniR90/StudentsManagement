package com.university.management.service;

import com.university.management.dto.participant.ParticipantResponseDTO;
import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import com.university.management.exception.personalException.ParticipantNotFoundException;
import com.university.management.mapper.ParticipantMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.ParticipantRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public List<ParticipantResponseDTO> findAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        validateNotEmpty(participants , "There are no participants");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ParticipantResponseDTO> findByNameIgnoreCase(String name) {
        List<Participant> participants = participantRepository.findByNameIgnoreCase(name);
        validateNotEmpty(participants, "Participant not found");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ParticipantResponseDTO> findBySurnameIgnoreCase(String surname) {
        List<Participant> participants = participantRepository.findBySurnameIgnoreCase(surname);
        validateNotEmpty(participants, "Participant not found");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ParticipantResponseDTO> findBySecondSurnameIgnoreCase(String secondSurname) {
        List<Participant> participants = participantRepository.findBySecondSurnameIgnoreCase(secondSurname);
        validateNotEmpty(participants , "Participant not found");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ParticipantResponseDTO findByEmailIgnoreCase(String email) {
        Participant participant = participantRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
        return ParticipantMapper.toResponse(participant);
    }

    public List<ParticipantResponseDTO> findAllByRGPDStatus(String rgpdStatus) {
        RGPD_Status validStatus = RGPD_Status.fromLabel(rgpdStatus);
        List<Participant> participants = participantRepository.findAllByRGPDStatus(validStatus);
        validateNotEmpty(participants , "There are no participants for this status");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ParticipantResponseDTO> findAllBySession(Long sessionId) {
        List<Participant> participants = participantRepository.findAllBySessionList_Id(sessionId);
        validateNotEmpty(participants , "There are no participants for this session");
        return participants.stream()
                .map(ParticipantMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ParticipantResponseDTO deleteByEmailIgnoreCase(String email) {
        Participant participant = participantRepository.findByEmailIgnoreCase(email)
                        .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
        participantRepository.delete(participant);
        return ParticipantMapper.toResponse(participant);
    }

    public long countAllParticipants() {
        return participantRepository.count();
    }

    private void validateNotEmpty(List<?> list , String message) {
        if(list.isEmpty()) {
            throw new ParticipantNotFoundException(message);
        }
    }
}