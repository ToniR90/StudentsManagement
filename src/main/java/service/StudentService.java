package service;

import entity.participant.student.Student;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.StudyYear;
import exception.personalException.StudentNotFoundException;
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

    public Student findStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if(!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }
        studentRepository.deleteById(id);
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

    public Student findByName(String name) {
        return studentRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student findBySurname(String surname) {
        return studentRepository.findBySurnameIgnoreCase(surname)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }
}