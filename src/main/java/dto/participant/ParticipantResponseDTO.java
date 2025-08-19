package dto.participant;

import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
public class ParticipantResponseDTO {
    private Long id;
    private String name;
    private String surname;
    private String secondSurname;
    private String email;
    private RGPD_Status rgpdStatus;
    private Set<String> extraEmails;
}
