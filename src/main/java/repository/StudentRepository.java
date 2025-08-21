package repository;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {

    List<Student> findAllByDegree(Degree degree);
    List<Student> findAllByStudyYear(StudyYear studyYear);
    List<Student> findAllByIsAlumniTrue();
}