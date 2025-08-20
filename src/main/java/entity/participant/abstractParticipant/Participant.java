package entity.participant.abstractParticipant;

import entity.session.abstractSession.Session;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "participants")
public abstract class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    @Size(min = 2 , max = 20 , message = "Name must be between 2 - 20 chars long")
    private String name;

    @NotBlank
    @Column(name = "surname")
    @Size(min = 2 , max = 20 , message = "Surname must be between 2 - 20 chars long")
    private String surname;

    @Column(name = "second_surname")
    private String secondSurname;

    @NotBlank
    @Column(name = "email" , nullable = false , unique = true)
    @Email(message = "Invalid format email")
    private String email;

    @NotNull(message = "RGPD status is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "rgpd_status" , nullable = false)
    private RGPD_Status rgpdStatus;

    @ElementCollection
    @CollectionTable(
            name = "participant_emails" ,
            joinColumns = @JoinColumn(name = "participant_id")
    )
    @Column(name = "extra_email")
    @Size(max = 3 , message = "Maximum 3 extra emails allowed")
    private Set<@Email(message = "Invalid email format") String> extraEmails;

    @ManyToMany
    @JoinTable(
            name = "participant_sessions" ,
            joinColumns = @JoinColumn(name = "participant_id") ,
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> sessionList;
}