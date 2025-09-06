package com.university.management.service;

import com.university.management.entity.participant.student.Student;
import com.university.management.entity.participant.student.studentEnum.Degree;
import com.university.management.entity.participant.student.studentEnum.StudyYear;
import com.university.management.exception.personalException.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        validateNotEmpty(students , "There are no students");
        return students;
    }

    public List<Student> findAllByDegree(String degreeCode) {
        Degree degree = Degree.fromCode(degreeCode);
        List<Student> students = studentRepository.findAllByDegree(degree);
        validateNotEmpty(students , "There are no students for the degree " + degreeCode);
        return students;
    }

    public List<Student> findAllByStudyYear(String studyYear) {
        StudyYear validYear = StudyYear.fromLabel(studyYear);
        List<Student> students = studentRepository.findAllByStudyYear(validYear);
        validateNotEmpty(students , "There are no students for the year " + studyYear);
        return students;
    }

    public List<Student> findAllAlumni() {
        List<Student> students = studentRepository.findAllByIsAlumniTrue();
        validateNotEmpty(students , "There are no alumni students");
        return students;
    }

    public long countAllStudents() {
        return studentRepository.count();
    }

    private void validateNotEmpty(List<?> list , String message) {
        if(list.isEmpty()) {
            throw new StudentNotFoundException(message);
        }
    }
}