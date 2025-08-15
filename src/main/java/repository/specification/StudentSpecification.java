package repository.specification;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.*;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.session.abstractSession.Session;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class StudentSpecification {

    public static Specification<Student> hasName(String name) {
        return (root, query, cb) ->
                name == null ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Student> hasSurname(String surname) {
        return (root, query, cb) ->
                surname == null ? null : cb.like(cb.lower(root.get("surname")), "%" + surname.toLowerCase() + "%");
    }

    public static Specification<Student> hasSecondSurname(String secondSurname) {
        return (root, query, cb) ->
                secondSurname == null ? null : cb.like(cb.lower(root.get("secondSurname")), "%" + secondSurname.toLowerCase() + "%");
    }

    public static Specification<Student> hasEmail(String email) {
        return (root, query, cb) ->
                email == null ? null : cb.equal(cb.lower(root.get("email")), email.toLowerCase());
    }

    public static Specification<Student> hasRGPDStatus(RGPD_Status status) {
        return (root, query, cb) ->
                status == null ? null : cb.equal(root.get("rgpdStatus"), status);
    }

    public static Specification<Student> hasDegree(Degree degree) {
        return (root, query, cb) ->
                degree == null ? null : cb.equal(root.get("degree"), degree);
    }

    public static Specification<Student> hasStudyYear(StudyYear studyYear) {
        return (root, query, cb) ->
                studyYear == null ? null : cb.equal(root.get("studyYear"), studyYear);
    }

    public static Specification<Student> isAlumni(Boolean isAlumni) {
        return (root, query, cb) ->
                isAlumni == null ? null : cb.equal(root.get("isAlumni"), isAlumni);
    }

    public static Specification<Student> hasAlumniType(AlumniType alumniType) {
        return (root, query, cb) ->
                alumniType == null ? null : cb.equal(root.get("alumniType"), alumniType);
    }

    public static Specification<Student> hasServiceAwareness(ServiceAwareness awareness) {
        return (root, query, cb) ->
                awareness == null ? null : cb.equal(root.get("serviceAwareness"), awareness);
    }

    public static Specification<Student> contactedAfter(LocalDate date) {
        return (root, query, cb) ->
                date == null ? null : cb.greaterThanOrEqualTo(root.get("firstContactDate"), date);
    }

    public static Specification<Student> contactedBefore(LocalDate date) {
        return (root, query, cb) ->
                date == null ? null : cb.lessThanOrEqualTo(root.get("firstContactDate"), date);
    }

    public static Specification<Student> hasObservationContaining(String keyword) {
        return (root, query, cb) ->
                keyword == null ? null : cb.like(cb.lower(root.get("personalObservation")), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<Student> hasExtraEmail(String email) {
        return (root, query, cb) -> {
            if (email == null) return null;
            query.distinct(true);
            Join<Student, String> join = root.join("extraEmails");
            return cb.equal(cb.lower(join.get("extraEmail")), email.toLowerCase());
        };
    }

    public static Specification<Student> hasSessionId(Long sessionId) {
        return (root, query, cb) -> {
            if (sessionId == null) return null;
            query.distinct(true);
            Join<Student, Session> join = root.join("sessionList");
            return cb.equal(join.get("id"), sessionId);
        };
    }
}