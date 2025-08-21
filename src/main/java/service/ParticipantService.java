package service;

import entity.participant.abstractParticipant.Participant;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import exception.personalException.ParticipantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public List<Participant> findAllParticipants() {
        return participantRepository.findAll();
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
        return participantRepository.findAllByRGPDStatus(validStatus);
    }

    public List<Participant> findAllBySession(Long sessionId) {
        List<Participant> participants = participantRepository.findAllBySessionList_Id(sessionId);
        if(participants.isEmpty()) {
            throw new ParticipantNotFoundException("No participants found for this session");
        }
        return participants;
    }

    public void deleteByEmail(String email) {
        Participant participant = participantRepository.findByEmailIgnoreCase(email)
                        .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
        participantRepository.delete(participant);
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