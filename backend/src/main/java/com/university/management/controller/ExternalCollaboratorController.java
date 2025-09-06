package com.university.management.controller;

import com.university.management.service.ExternalCollaboratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("external-collaborator")
@RequiredArgsConstructor
public class ExternalCollaboratorController {

    private final ExternalCollaboratorService externalCollaboratorService;
}
