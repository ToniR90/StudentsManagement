package com.university.management.controller;

import com.university.management.dto.externalCollaborator.ExternalCollaboratorRequestDTO;
import com.university.management.dto.externalCollaborator.ExternalCollaboratorResponseDTO;
import com.university.management.service.ExternalCollaboratorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("external-collaborator")
@RequiredArgsConstructor
public class ExternalCollaboratorController {

    private final ExternalCollaboratorService externalCollaboratorService;

    @PostMapping
    public ResponseEntity<ExternalCollaboratorResponseDTO> createExternalCollaborator(@Valid @RequestBody ExternalCollaboratorRequestDTO requestDTO) {
        ExternalCollaboratorResponseDTO externalCollaboratorResponse = externalCollaboratorService.saveExternalCollaborator(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(externalCollaboratorResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExternalCollaboratorResponseDTO>> getAllExternalCollaborators() {
        List<ExternalCollaboratorResponseDTO> responseList = externalCollaboratorService
                .findAllExternalCollaborator();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/by-affiliated-company")
    public ResponseEntity<List<ExternalCollaboratorResponseDTO>> getByAffiliatedCompany(String affiliatedCompany) {
        List<ExternalCollaboratorResponseDTO> responseList = externalCollaboratorService
                .findByAffiliatedCompany(affiliatedCompany);
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        Long count = externalCollaboratorService.countAllExternalCollaborators();
        return ResponseEntity.ok(count);
    }
}
