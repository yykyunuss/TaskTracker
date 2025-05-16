package com.example.tasktracker.service;

import com.example.tasktracker.dto.task.*;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.mapper.TaskMapper;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<AllTasksResponse> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toAllTasksResponse(tasks);
    }

    public GetTaskResponse getTask(long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found"));
        return taskMapper.toGetTaskResponse(task);
    }

    public TaskAddResponse addTask(TaskAddRequest taskAddRequest) {
        Task task = taskMapper.toAddRequestEntity(taskAddRequest);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toAddResponse(savedTask);
    }

    public List<TaskAddResponse> addTasks(List<TaskAddRequest> taskAddRequests) {
        List<Task> tasks = taskMapper.toAddRequestEntities(taskAddRequests);
        List<Task> savedTasks = taskRepository.saveAll(tasks);
        return taskMapper.toAddResponses(savedTasks);
    }

    public TaskUpdateResponse updateTask(long id, TaskUpdateRequest taskUpdateRequest) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task not found " + id));

        task.setDescription(taskUpdateRequest.getDescription());
        task.setStatus(taskUpdateRequest.getStatus());
        task.setPriority(taskUpdateRequest.getPriority());
        task.setTitle(taskUpdateRequest.getTitle());
        task.setDueDate(taskUpdateRequest.getDueDate());

        Task updatedTask = taskRepository.save(task);
        return taskMapper.toTaskUpdateResponse(updatedTask);
    }

    public void deleteTask(long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else {
            throw new NoSuchElementException("Task not found " + id);
        }
    }

}
