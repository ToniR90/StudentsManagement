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
        StudentResponseDTO studentResponse = studentService.saveStudent(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents () {
        List<StudentResponseDTO> responseList = studentService
                .findAllStudents();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-degree")
    public ResponseEntity<List<StudentResponseDTO>> getByDegree(@RequestParam String code) {
        List<StudentResponseDTO> responseList = studentService
                .findAllByDegree(code);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-study-year")
    public ResponseEntity<List<StudentResponseDTO>> getByStudyYear(@RequestParam String year) {
        List<StudentResponseDTO> responseList = studentService
                .findAllByStudyYear(year);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/alumni")
    public ResponseEntity<List<StudentResponseDTO>> getAllAlumni() {
        List<StudentResponseDTO> responseList = studentService
                .findAllAlumni();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        Long count = studentService.countAllStudents();
        return ResponseEntity.ok(count);
    }
}