package com.vladimirkomlev.zimadchallenge.services;

import com.vladimirkomlev.zimadchallenge.config.AppProperties;
import com.vladimirkomlev.zimadchallenge.models.CreateTaskRequest;
import com.vladimirkomlev.zimadchallenge.models.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

import static org.springframework.http.HttpMethod.GET;

@Service
public class TaskService {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;

    @Autowired
    public TaskService(AppProperties appProperties, RestTemplate restTemplate) {
        this.appProperties = appProperties;
        this.restTemplate = restTemplate;
    }

    public TaskResponse createATask(CreateTaskRequest request) {
        return restTemplate.postForObject(
                appProperties.getBaseUrl() + "/v1/tasks",
                request,
                TaskResponse.class
        );
    }

    public Set<TaskResponse> getActiveTasks() {
        return restTemplate.exchange(
                appProperties.getBaseUrl() + "/v1/tasks",
                GET,
                null,
                new ParameterizedTypeReference<Set<TaskResponse>>() {}
        ).getBody();
    }
}
