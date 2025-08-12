package exception.personalException;

public class InvalidRGPDStatusException extends RuntimeException {
    public InvalidRGPDStatusException(String label) {
        super("Invalid RGPD status: " + label);
    }
}
