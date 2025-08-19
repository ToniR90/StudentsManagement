package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.student.ServiceAwarenessSelection;
import dto.student.StudentRequestDTO;
import entity.participant.abstractParticipant.participantEnum.RGPD_Status;
import entity.participant.student.studentEnum.Degree;
import entity.participant.student.studentEnum.ServiceAwareness;
import entity.participant.student.studentEnum.StudyYear;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateStudentSuccessfully() throws Exception {
        StudentRequestDTO dto = new StudentRequestDTO();
        dto.setName("Toni");
        dto.setSurname("Puig");
        dto.setSecondSurname("Garcia");
        dto.setEmail("toni@example.com");
        dto.setRgpdStatus(RGPD_Status.SIGNET);
        dto.setExtraEmails(Set.of("toni.alt@example.com", "toni.work@example.com"));
        dto.setDegree(Degree.CAFE);
        dto.setStudyYear(StudyYear.THIRD);
        dto.setIsAlumni(false);
        dto.setAlumniType(null);
        dto.setServiceAwarenessSelection(new ServiceAwarenessSelection(ServiceAwareness.MOODLE, "Campus virtual"));
        dto.setFirstContactDate(LocalDate.of(2025, 8, 18));
        dto.setPersonalObservation("Interessat en projectes d'IA");

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Toni"))
                .andExpect(jsonPath("$.email").value("toni@example.com"))
                .andExpect(jsonPath("$.degree").value("CAFE"))
                .andExpect(jsonPath("$.serviceAwareness").value("MOODLE"));

    }

}