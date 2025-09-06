package com.university.management.service;

import com.university.management.dto.student.StudentRequestDTO;
import com.university.management.dto.student.StudentResponseDTO;
import com.university.management.entity.participant.student.Student;
import com.university.management.entity.participant.student.studentEnum.Degree;
import com.university.management.entity.participant.student.studentEnum.StudyYear;
import com.university.management.exception.personalException.StudentNotFoundException;
import com.university.management.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDTO saveStudent(StudentRequestDTO studentRequest) {
        Student student = StudentMapper.toEntity(studentRequest);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toResponse(savedStudent);
    }

    public List<StudentResponseDTO> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        validateNotEmpty(students , "There are no students");
        return students.stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> findAllByDegree(String degreeCode) {
        Degree degree = Degree.fromCode(degreeCode);
        List<Student> students = studentRepository.findAllByDegree(degree);
        validateNotEmpty(students , "There are no students for the degree " + degreeCode);
        return students.stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> findAllByStudyYear(String studyYear) {
        StudyYear validYear = StudyYear.fromLabel(studyYear);
        List<Student> students = studentRepository.findAllByStudyYear(validYear);
        validateNotEmpty(students , "There are no students for the year " + studyYear);
        return students.stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDTO> findAllAlumni() {
        List<Student> students = studentRepository.findAllByIsAlumniTrue();
        validateNotEmpty(students , "There are no alumni students");
        return students.stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
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