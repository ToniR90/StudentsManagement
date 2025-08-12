package exception.personalException;

public class InvalidAlumniTypeException extends RuntimeException {
    public InvalidAlumniTypeException(String label) {
        super("Invalid alumni type: " + label);
    }
}
