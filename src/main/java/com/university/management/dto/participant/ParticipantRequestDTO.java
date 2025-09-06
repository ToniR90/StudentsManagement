package com.university.management.dto.participant;

import com.university.management.entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ParticipantRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be 2 - 20 chars long")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(min = 2, max = 20, message = "Surname must be 2 - 20 chars long")
    private String surname;

    @Size(max = 20, message = "Surname must be 20 chars long max")
    private String secondSurname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "RGPD status is required")
    private RGPD_Status rgpdStatus;

    @Size(max = 3, message = "Max 3 extra emails")
    private Set<@Email(message = "Invalid email format") String> extraEmails;
}
