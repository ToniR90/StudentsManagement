package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
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
    @Column(name = "email" , nullable = false)
    @Email(message = "Invalid format email")
    private String email;

    @ElementCollection
    @CollectionTable(
            name = "participant_emails" ,
            joinColumns = @JoinColumn(name = "participant_id")
    )
    @Column(name = "extra_email")
    private List<@Email(message = "Invalid email format") String> emailList;

    private List<Session> sessionList;
}
