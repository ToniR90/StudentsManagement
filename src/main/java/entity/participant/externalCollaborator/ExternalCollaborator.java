package entity.participant.externalCollaborator;

import entity.participant.abstractParticipant.Participant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "external_collaborators")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExternalCollaborator extends Participant {

    @NotBlank
    @Size(max = 100)
    @Column(name = "affiliated_company" , nullable = false , length = 100)
    private String affiliatedCompany;
}
