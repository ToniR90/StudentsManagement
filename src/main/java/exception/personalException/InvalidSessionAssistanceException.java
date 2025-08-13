package exception.personalException;

public class InvalidSessionAssistanceException extends RuntimeException {
    public InvalidSessionAssistanceException(String label) {
        super("Invalid Session Assistance: " + label);
    }
}
