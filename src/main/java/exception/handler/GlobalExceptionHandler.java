package exception.handler;

import exception.ErrorDetails;
import exception.personalException.InvalidAlumniTypeException;
import exception.personalException.InvalidDegreeException;
import exception.personalException.InvalidRGPDStatusException;
import exception.personalException.InvalidStudyYearException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRGPDStatusException.class)
    public ResponseEntity<ErrorDetails> handleInvalidRGPDStatus(InvalidRGPDStatusException ex) {
        ErrorDetails error = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                "Invalid RGPD Status",
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
}