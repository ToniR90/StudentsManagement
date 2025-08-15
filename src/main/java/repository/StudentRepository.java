package repository;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {

    Student findByNameIgnoreCaseAndSurnameIgnoreCase(String name , String surname);
    List<Student> getAllByDegreeIgnoreCase(Degree degree);
    List<Student> getAllByStudyYearIgnoreCase(StudyYear studyYear);
    List<Student> getAllAlumni();
}