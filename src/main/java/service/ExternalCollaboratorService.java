package service;

import entity.participant.externalCollaborator.ExternalCollaborator;
import exception.personalException.ExternalCollaboratorNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ExternalCollaboratorRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ExternalCollaboratorService {

    private final ExternalCollaboratorRepository externalCollaboratorRepository;

    public List<ExternalCollaborator> findAllExternalCollaborator() {
        return externalCollaboratorRepository.findAll();
    }

    public ExternalCollaborator findExternalCollaboratorById(Long id) {
        return externalCollaboratorRepository.findById(id)
                .orElseThrow(() -> new ExternalCollaboratorNotFoundException("External Collaborator not found"));
    }

    public ExternalCollaborator saveExternalCollaborator(ExternalCollaborator externalCollaborator) {
        return externalCollaboratorRepository.save(externalCollaborator);
    }

    public void deleteExternalCollaborator(Long id) {
        if(!externalCollaboratorRepository.existsById(id)) {
            throw new ExternalCollaboratorNotFoundException("External Collaborator not found");
        }
        externalCollaboratorRepository.deleteById(id);
    }
}