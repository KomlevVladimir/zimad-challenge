package com.vladimirkomlev.zimadchallenge.tests;

import com.vladimirkomlev.zimadchallenge.models.CreateTaskRequest;
import com.vladimirkomlev.zimadchallenge.models.TaskResponse;
import com.vladimirkomlev.zimadchallenge.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Set;
import java.util.stream.Stream;

import static com.vladimirkomlev.zimadchallenge.data.DataGenerator.randomValidTaskRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@SpringBootTest
class CreateANewTaskTests {

    @Autowired
    private TaskService taskService;

    @Test
    void createANewTaskWithValidDataTest() {
        CreateTaskRequest request = randomValidTaskRequest();
        Set<TaskResponse> tasksBefore = taskService.getActiveTasks();
        TaskResponse createdTask = taskService.createATask(request);
        Set<TaskResponse> tasksAfter = taskService.getActiveTasks();
        tasksBefore.add(createdTask);

        assertAll(
                () -> assertEquals(
                        request.getContent(),
                        createdTask.getContent(),
                        "Content in the request is " + request.getContent() +
                                " but in the response is " + createdTask.getContent()
                        ),
                () -> assertNull(createdTask.getLabelIds(), "Label ids field is not null"),
                () -> assertEquals(
                        request.getOrder(),
                        createdTask.getOrder(),
                        "Order in the request is " + request.getOrder() +
                                " but in the response is " + createdTask.getOrder()
                        ),
                () -> assertEquals(
                        request.getPriority(),
                        createdTask.getPriority(),
                        "Priority in the request is " + request.getPriority() +
                                " but in the response is " + createdTask.getPriority()
                        ),
                () -> assertEquals(
                        request.getProjectId(),
                        createdTask.getProjectId(),
                        "Project id in the request is " + request.getProjectId() +
                                " but in the response is " + createdTask.getProjectId()
                        ),
                () -> assertEquals(
                        request.getSectionId(),
                        createdTask.getSectionId(),
                        "Section id in the request is " + request.getSectionId() +
                                " but in the response is " + createdTask.getSectionId()
                        ),
                () -> assertFalse(createdTask.isCompleted(), "Completed field should is true but should be false"),
                () -> assertEquals(0, createdTask.getParent(), "Parent field is not equal to 0"),
                () -> assertEquals(0, createdTask.getCommentCount(), "Comment count is not equal to 0"),
                () -> assertEquals("https://todoist.com/showTask?id=" + createdTask.getId(), createdTask.getUrl()),
                () -> assertEquals(tasksBefore, tasksAfter, "Task is not created")
        );
    }

    @Test
    void createTwoTasksWithTheSameContentTest() {
        CreateTaskRequest firstRequest = randomValidTaskRequest();
        TaskResponse firstTask = taskService.createATask(firstRequest);
        CreateTaskRequest secondTask = randomValidTaskRequest().withContent(firstRequest.getContent());
        Set<TaskResponse> tasksBefore = taskService.getActiveTasks();
        TaskResponse secondResponse = taskService.createATask(secondTask);
        Set<TaskResponse> tasksAfter = taskService.getActiveTasks();
        tasksBefore.add(secondResponse);

        assertAll(
                () -> assertEquals(
                        firstTask.getContent(),
                        secondResponse.getContent(),
                        "Content in the first response is " + firstTask.getContent() +
                                " but in the second response is " + secondResponse.getContent()
                        ),
                () -> assertEquals(tasksBefore, tasksAfter, "Task should not be created")
        );
    }

    private static Stream<String> params() {
        return Stream.of("", "   ", null);
    }

    @ParameterizedTest
    @MethodSource("params")
    void createANewTaskWithInvalidContentTest(final String content) {
        CreateTaskRequest request = randomValidTaskRequest().withContent(content);
        Set<TaskResponse> tasksBefore = taskService.getActiveTasks();
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () ->
                taskService.createATask(request));
        Set<TaskResponse> tasksAfter = taskService.getActiveTasks();

        assertAll(
                () -> assertEquals(BAD_REQUEST, exception.getStatusCode(), "Status code is not " + BAD_REQUEST),
                () -> assertEquals(tasksBefore, tasksAfter, "Task should not be created")
        );
    }
}
