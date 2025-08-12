package exception.personalException;

public class InvalidStudyYearException extends RuntimeException {
    public InvalidStudyYearException(String label) {
        super("Invalid study year: " + label);
    }
}
