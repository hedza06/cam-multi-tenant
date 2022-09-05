package com.hedza06.cammultitenant.services;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RepositoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class ProcessDefinitionService {

    private final RepositoryService repositoryService;

    public void deploy(MultipartFile multipartFile, String tenantId) throws IOException
    {
        repositoryService
            .createDeployment()
            .tenantId(tenantId)
            .addInputStream(multipartFile.getOriginalFilename(), multipartFile.getInputStream())
            .deploy();
    }
}
