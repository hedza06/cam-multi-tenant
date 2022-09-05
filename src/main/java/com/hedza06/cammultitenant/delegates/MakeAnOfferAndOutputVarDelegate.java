package com.hedza06.cammultitenant.delegates;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("MakeAnOfferAndOutputVarDelegate")
public class MakeAnOfferAndOutputVarDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String tenantId = delegateExecution.getTenantId();

        log.info("APP-01 executing...");
        log.info("Tenant id is: {}", tenantId);

        delegateExecution.setVariable("offerCreated", false);
    }
}
