package service;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllByDegree(String degreeCode) {
        Degree degree = Degree.fromCode(degreeCode);
        return studentRepository.findAllByDegree(degree);
    }

    public List<Student> findAllByStudyYear(String studyYear) {
        StudyYear validYear = StudyYear.fromLabel(studyYear);
        return studentRepository.findAllByStudyYear(validYear);
    }

    public List<Student> findAllAlumni() {
        return studentRepository.findAllByIsAlumniTrue();
    }
}