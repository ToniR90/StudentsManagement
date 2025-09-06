package com.university.management.repository;

import com.university.management.entity.participant.externalCollaborator.ExternalCollaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExternalCollaboratorRepository extends JpaRepository<ExternalCollaborator, Long> {

    List<ExternalCollaborator> findByAffiliatedCompanyIgnoreCase(String affiliatedCompany);
}
