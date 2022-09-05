package com.hedza06.cammultitenant.controllers;

import com.hedza06.cammultitenant.services.ProcessDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/process-definition")
public class ProcessDefinitionController {

    private final ProcessDefinitionService processDefinitionService;


    @PostMapping(value = "/{tenantId}/deploy")
    public ResponseEntity<Void> deployResource(@RequestParam("file") MultipartFile multipartFile, @PathVariable String tenantId)
        throws IOException
    {
        processDefinitionService.deploy(multipartFile, tenantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
