package exception.personalException;

public class InvalidDegreeException extends RuntimeException {
    public InvalidDegreeException(String code) {
        super("Invalid Degree: " + code);
    }
}
