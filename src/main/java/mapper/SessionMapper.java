package mapper;

import dto.session.SessionRequestDTO;
import entity.session.abstractSession.Session;

public class SessionMapper {

    public static Session toEntity(SessionRequestDTO dto) {
        return Session.builder()
                .date(dto.getDate())
                .summary(dto.getSummary())
                .build();
    }

    public static SessionRequestDTO toDTO(Session session) {
        return new SessionRequestDTO(
                session.getDate(),
                session.getSummary()
        );
    }
}