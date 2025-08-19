package service;

import entity.participant.abstractParticipant.Participant;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.session.abstractSession.Session;
import exception.personalException.ParticipantNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ParticipantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public List<Participant> findAllParticipants() {
        return participantRepository.findAllParticipants();
    }

    public List<Participant> findByNameIgnoreCase(String name) {
        List<Participant> participants = participantRepository.findByNameIgnoreCase(name);
        if(participants.isEmpty()) {
            throw new ParticipantNotFoundException("Participant not found");
        }
        return participants;
    }

    public List<Participant> findBySurnameIgnoreCase(String surname) {
        List<Participant> participants = participantRepository.findBySurnameIgnoreCase(surname);
        if(participants.isEmpty()) {
            throw new ParticipantNotFoundException("Participant not found");
        }
        return participants;
    }

    public Participant findByEmailIgnoreCase(String email) {
        return participantRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ParticipantNotFoundException("Participant not found"));
    }

    public List<Participant> findByRGPDStatus(String rgpdStatus) {
        RGPD_Status validStatus = RGPD_Status.fromLabel(rgpdStatus);

        return participantRepository.findAllByRGPDStatus(validStatus);
    }

    public List<Participant> findAllBySession(Session session) {
        List<Participant> participants = participantRepository.findAllBySession(session);
        if(participants.isEmpty()) {
            throw new ParticipantNotFoundException("No participants found for this session");
        }
        return participants;
    }
}
