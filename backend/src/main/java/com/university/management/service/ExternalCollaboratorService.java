package com.university.management.service;

import com.university.management.dto.externalCollaborator.ExternalCollaboratorRequestDTO;
import com.university.management.dto.externalCollaborator.ExternalCollaboratorResponseDTO;
import com.university.management.entity.participant.externalCollaborator.ExternalCollaborator;
import com.university.management.exception.personalException.ExternalCollaboratorNotFoundException;
import com.university.management.mapper.ExternalCollaboratorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.university.management.repository.ExternalCollaboratorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExternalCollaboratorService {

    private final ExternalCollaboratorRepository externalCollaboratorRepository;

    public ExternalCollaboratorResponseDTO saveExternalCollaborator(ExternalCollaboratorRequestDTO externalCollaboratorRequest) {
        ExternalCollaborator externalCollaborator = ExternalCollaboratorMapper.toEntity(externalCollaboratorRequest);
        ExternalCollaborator savedExternalCollaborator = externalCollaboratorRepository.save(externalCollaborator);
        return ExternalCollaboratorMapper.toResponse(savedExternalCollaborator);
    }

    public List<ExternalCollaboratorResponseDTO> findAllExternalCollaborator() {
        List<ExternalCollaborator> externalCollaborators = externalCollaboratorRepository.findAll();
        validateNotEmpty(externalCollaborators , "There are no external collaborators");
        return externalCollaborators.stream()
                .map(ExternalCollaboratorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ExternalCollaboratorResponseDTO> findByAffiliatedCompany(String affiliatedCompany) {
        List<ExternalCollaborator> externalCollaborators = externalCollaboratorRepository
                .findByAffiliatedCompanyIgnoreCase(affiliatedCompany);
        validateNotEmpty(externalCollaborators , "There are no external collaborators for company " + affiliatedCompany);
        return externalCollaborators.stream()
                .map(ExternalCollaboratorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public long countAllExternalCollaborators() {
        return externalCollaboratorRepository.count();
    }

    private void validateNotEmpty(List<?> list , String message) {
        if(list.isEmpty()) {
            throw new ExternalCollaboratorNotFoundException(message);
        }
    }
}