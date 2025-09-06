package com.university.management.dto.student;

import com.university.management.entity.participant.student.studentEnum.ServiceAwareness;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAwarenessSelection {

    @NotNull(message = "Service awareness is required")
    private ServiceAwareness serviceAwareness;

    @Size(max = 100, message = "User label too long")
    private String userLabel;

    public String getDisplayLabel() {
        if (userLabel != null && !userLabel.isBlank()) {
            return serviceAwareness.getLabel() + userLabel;
        }
        return serviceAwareness.getLabel();
    }
}
