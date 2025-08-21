package exception.personalException;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(String message) {
        super("Session not found");
    }
}
