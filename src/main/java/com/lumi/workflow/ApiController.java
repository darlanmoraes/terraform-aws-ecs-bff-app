package com.lumi.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/execute")
public class ApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    private final RuntimeService runtimeService;
    private final TaskService taskService;

    @Autowired
    public ApiController(final RuntimeService runtimeService, final TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProcessKey execute() {
        final ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("execute-process", new HashMap<>());
        return new ProcessKey(processInstance.getProcessInstanceId());
    }
}