package dto.student;

import entity.student.studentEnum.ServiceAwareness;
import exception.personalException.InvalidServiceAwarenessException;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServiceAwarenessSelection {
    private final ServiceAwareness serviceAwareness;

    @Size(max = 100)
    private final String userLabel;

    public String getDisplayLabel() {
        if (userLabel != null && !userLabel.isBlank()) {
            return serviceAwareness.getLabel() + userLabel;
        }
        return serviceAwareness.getLabel();
    }
}
