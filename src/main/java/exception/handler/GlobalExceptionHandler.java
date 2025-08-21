package exception.handler;

import exception.ErrorDetails;
import exception.personalException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GroupSessionNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleGroupSessionNotFound(GroupSessionNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                "Group session not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IndividualSessionNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIndividualSessionNotFound(IndividualSessionNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                "Individual session not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(SessionNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleSessionNotFound(SessionNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                "Session not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(InvalidRGPDStatusException.class)
    public ResponseEntity<ErrorDetails> handleInvalidRGPDStatus(InvalidRGPDStatusException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid RGPD Status",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidParticipantTypeException.class)
    public ResponseEntity<ErrorDetails> handleInvalidParticipantType(InvalidParticipantTypeException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Participant Type",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidDegreeException.class)
    public ResponseEntity<ErrorDetails> handleInvalidDegreeException(InvalidDegreeException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Degree",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidStudyYearException.class)
    public ResponseEntity<ErrorDetails> handleInvalidStudyYear(InvalidStudyYearException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Study Year",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidAlumniTypeException.class)
    public ResponseEntity<ErrorDetails> handleInvalidAlumniType(InvalidAlumniTypeException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Alumni Type",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidServiceAwarenessException.class)
    public ResponseEntity<ErrorDetails> handleInvalidServiceAwareness(InvalidServiceAwarenessException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Service Awareness",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidSessionTypeException.class)
    public ResponseEntity<ErrorDetails> handleInvalidSessionType(InvalidSessionTypeException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Session Type",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidSessionAssistanceException.class)
    public ResponseEntity<ErrorDetails> handleInvalidSessionAssistance(InvalidSessionAssistanceException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid Session Assistance",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleStudentNotFound(StudentNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                "Student not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ParticipantNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleParticipantNotFound(ParticipantNotFoundException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                "Participant not found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}