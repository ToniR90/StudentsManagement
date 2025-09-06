package com.university.management.mapper;

import com.university.management.dto.student.StudentRequestDTO;
import com.university.management.dto.student.StudentResponseDTO;
import com.university.management.entity.participant.student.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequestDTO dto) {
        return Student.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .secondSurname(dto.getSecondSurname())
                .email(dto.getEmail())
                .rgpdStatus(dto.getRgpdStatus())
                .extraEmails(dto.getExtraEmails())
                .degree(dto.getDegree())
                .studyYear(dto.getStudyYear())
                .alumni(dto.getIsAlumni())
                .alumniType(dto.getAlumniType())
                .serviceAwareness(dto.getServiceAwarenessSelection().getServiceAwareness())
                .firstContactDate(dto.getFirstContactDate())
                .personalObservation(dto.getPersonalObservation())
                .build();
    }

    public static StudentResponseDTO toResponse(Student student) {
        return StudentResponseDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .secondSurname(student.getSecondSurname())
                .email(student.getEmail())
                .rgpdStatus(student.getRgpdStatus())
                .extraEmails(student.getExtraEmails())
                .degree(student.getDegree())
                .studyYear(student.getStudyYear())
                .isAlumni(student.isAlumni())
                .alumniType(student.getAlumniType())
                .serviceAwareness(student.getServiceAwareness())
                .serviceAwarenessDisplayLabel(student.getServiceAwareness().getLabel())
                .firstContactDate(student.getFirstContactDate())
                .personalObservation(student.getPersonalObservation())
                .build();
    }
}