package exception.personalException;

public class InvalidServiceAwarenessException extends RuntimeException {
    public InvalidServiceAwarenessException(String label) {
        super("Invalid service awareness: " + label);
    }
}
