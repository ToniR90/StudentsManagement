package com.university.management.repository;

import com.university.management.entity.participant.student.Student;
import com.university.management.entity.participant.student.studentEnum.Degree;
import com.university.management.entity.participant.student.studentEnum.StudyYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {

    List<Student> findAllByDegree(Degree degree);
    List<Student> findAllByStudyYear(StudyYear studyYear);
    List<Student> findAllByIsAlumniTrue();
}