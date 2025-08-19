package controller;

import dto.student.StudentRequestDTO;
import dto.student.StudentResponseDTO;
import entity.participant.student.Student;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mapper.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

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

    /*@GetMapping("/by-name")
    public ResponseEntity<List<StudentResponseDTO>> getByName(@RequestParam String name) {
        List<Student> students = studentService.findByName(name);
        List<StudentResponseDTO> responseList = students
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }*/

    /*@GetMapping("/by-surname")
    public ResponseEntity<List<StudentResponseDTO>> getBySurname(@RequestParam String surname) {
        List<Student> students = studentService.findBySurname(surname);
        List<StudentResponseDTO> responseList = students
                .stream()
                .map(StudentMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }*/

    /*@GetMapping("/by-email")
    public ResponseEntity<StudentResponseDTO> getByEmail(@RequestParam String email) {
        Student student = studentService.findByEmail(email);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StudentMapper.toResponse(student));
    }*/

    @GetMapping("/by-degree")
    public ResponseEntity<List<StudentResponseDTO>> getByDegree(@RequestParam String code) {
        List<Student> students = studentService.getAllByDegree(code);
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
}
