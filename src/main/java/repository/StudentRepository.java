package repository;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Long> {

    Optional<Student> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
    List<Student> findAllByDegree(Degree degree);
    List<Student> findAllByStudyYear(StudyYear studyYear);
    List<Student> findAllByIsAlumniTrue();
}