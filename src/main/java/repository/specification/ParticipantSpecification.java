/*package repository.specification;

import entity.participant.abstractParticipant.Participant;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import org.springframework.data.jpa.domain.Specification;

public class ParticipantSpecification {

    public static Specification<Participant> hasName(String name) {
        return (root, query, cb) ->
                name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Participant> hasSurname(String surname) {
        return (root, query, cb) ->
                surname == null ? null : cb.like(cb.lower(root.get("surname")), "%" + surname.toLowerCase() + "%");
    }

    public static Specification<Participant> hasSecondSurname(String secondSurname) {
        return (root, query, cb) ->
                secondSurname == null ? null : cb.like(cb.lower(root.get("secondSurname")), "%" + secondSurname.toLowerCase() + "%");
    }

    public static Specification<Participant> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null : cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }

    public static Specification<Participant> hasRGPDStatus(RGPD_Status status) {
        return (root, query, cb) ->
                status == null ? null : cb.equal(root.get("rgpdStatus"), status);
    }
}*/