package com.university.management.entity.session.groupSession;

import com.university.management.entity.participant.abstractParticipant.Participant;
import com.university.management.entity.session.abstractSession.Session;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "group_sessions")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GroupSession extends Session {

    @ManyToMany
    @JoinTable(
            name = "group_session_assistants",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    @OrderBy("surname ASC , name ASC")
    private Set<Participant> assistants;

    @ManyToMany
    @JoinTable(
            name = "group_session_collaborators",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    @OrderBy("surname ASC , name ASC")
    private Set<Participant> collaborators;

    @DecimalMin(value = "0.0" , message = "Assistance must be non-negative")
    @Column(name = "assistance", precision = 5, scale = 2)
    private BigDecimal assistance = BigDecimal.ZERO;

    @Size(max = 100)
    @NotBlank
    @Column(name = "classroom")
    private String classroom;

    @ElementCollection
    @CollectionTable(name = "group_session_material" , joinColumns = @JoinColumn(name = "session_id"))
    @OrderBy("value ASC")
    @Size(max = 50 , message = "Maximum 50 materials allowed")
    private List<String> material;

    @Size(max = 100)
    @Column(name = "class_ticket")
    private String classTicket;
}