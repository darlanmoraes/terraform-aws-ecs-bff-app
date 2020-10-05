package com.lumi.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Execute implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(Execute.class);

    @Override
    public void execute(final DelegateExecution execution) {
        LOGGER.info("Executed...");
    }

}
