package com.university.management.controller;

import com.university.management.dto.student.StudentRequestDTO;
import com.university.management.dto.student.StudentResponseDTO;
import com.university.management.entity.participant.student.Student;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.university.management.mapper.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.university.management.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody StudentRequestDTO requestDTO) {
        Student student = StudentMapper.toEntity(requestDTO);
        Student savedStudent = studentService.saveStudent(student);
        StudentResponseDTO responseDTO = StudentMapper.toResponse(savedStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents () {
        List<Student> participants = studentService.findAllStudents();
        List<StudentResponseDTO> responseList = participants
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-degree")
    public ResponseEntity<List<StudentResponseDTO>> getByDegree(@RequestParam String code) {
        List<Student> students = studentService.findAllByDegree(code);
        List<StudentResponseDTO> responseList = students
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-study-year")
    public ResponseEntity<List<StudentResponseDTO>> getByStudyYear(@RequestParam String year) {
        List<Student> students = studentService.findAllByStudyYear(year);
        List<StudentResponseDTO> responseList = students
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/alumni")
    public ResponseEntity<List<StudentResponseDTO>> getAllAlumni() {
        List<Student> students = studentService.findAllAlumni();
        List<StudentResponseDTO> responseList = students
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        Long count = studentService.countAllStudents();
        return ResponseEntity.ok(count);
    }
}