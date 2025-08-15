/*package repository.predicate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;

public class ParticipantPredicate {

    public static Predicate nameLike(Root<?> root, CriteriaBuilder cb, String name) {
        return name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Predicate surnameLike(Root<?> root, CriteriaBuilder cb, String surname) {
        return surname == null ? null : cb.like(cb.lower(root.get("surname")), "%" + surname.toLowerCase() + "%");
    }

    public static Predicate secondSurnameLike(Root<?> root, CriteriaBuilder cb, String secondSurname) {
        return secondSurname == null ? null : cb.like(cb.lower(root.get("secondSurname")), "%" + secondSurname.toLowerCase() + "%");
    }

    public static Predicate emailEquals(Root<?> root, CriteriaBuilder cb, String email) {
        return email == null ? null : cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }

    public static Predicate rgpdStatusEquals(Root<?> root, CriteriaBuilder cb, RGPD_Status status) {
        return status == null ? null : cb.equal(root.get("rgpdStatus"), status);
    }
}*/