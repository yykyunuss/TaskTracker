package com.example.tasktracker.controller;

import com.example.tasktracker.dto.*;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TaskController {

    TaskService taskService;
    /**
     * HELLO ENDPOINT
     */
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<AllTasksResponse> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/task/{id}")
    public GetTaskResponse getTask(@PathVariable long id) {
        return taskService.getTask(id);
    }

    @PostMapping("/addtask")
    public TaskAddResponse addTask(@RequestBody TaskAddRequest taskAddRequest) {
        return taskService.addTask(taskAddRequest);
    }

    @PostMapping("/addtasks")
    public List<TaskAddResponse> addTask(@RequestBody List<TaskAddRequest> taskAddRequests) {
        return taskService.addTasks(taskAddRequests);
    }

    @PutMapping("/updatetask/{id}")
    public TaskUpdateResponse updateTask(@PathVariable long id, @RequestBody TaskUpdateRequest taskUpdateRequest) {
        return taskService.updateTask(id, taskUpdateRequest);
    }

    @DeleteMapping("/deletetask/{id}")
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }

}
