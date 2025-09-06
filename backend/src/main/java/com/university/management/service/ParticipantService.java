package com.university.management.service;

import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import com.university.management.exception.personalException.ParticipantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.ParticipantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public List<Participant> findAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        validateNotEmpty(participants , "There are no participants");
        return participants;
    }

    public List<Participant> findByNameIgnoreCase(String name) {
        List<Participant> participants = participantRepository.findByNameIgnoreCase(name);
        validateNotEmpty(participants, "Participant not found");
        return participants;
    }

    public List<Participant> findBySurnameIgnoreCase(String surname) {
        List<Participant> participants = participantRepository.findBySurnameIgnoreCase(surname);
        validateNotEmpty(participants, "Participant not found");
        return participants;
    }

    public Participant findByEmailIgnoreCase(String email) {
        return participantRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
    }

    public List<Participant> findAllByRGPDStatus(String rgpdStatus) {
        RGPD_Status validStatus = RGPD_Status.fromLabel(rgpdStatus);
        List<Participant> participants = participantRepository.findAllByRGPDStatus(validStatus);
        validateNotEmpty(participants , "There are no participants for this status");
        return participants;
    }

    public List<Participant> findAllBySession(Long sessionId) {
        List<Participant> participants = participantRepository.findAllBySessionList_Id(sessionId);
        validateNotEmpty(participants , "There are no participants for this session");
        return participants;
    }

    public Participant deleteByEmailIgnoreCase(String email) {
        Participant participant = participantRepository.findByEmailIgnoreCase(email)
                        .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
        participantRepository.delete(participant);
        return participant;
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