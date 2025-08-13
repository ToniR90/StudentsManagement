package service;

import entity.participant.student.Student;
import exception.personalException.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student findByNameAndSurname(String name , String surname) {
        return studentRepository.findByNameAndSurname(name , surname);
    }
}
