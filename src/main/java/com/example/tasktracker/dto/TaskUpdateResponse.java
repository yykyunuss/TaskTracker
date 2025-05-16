package com.example.tasktracker.dto;

import com.example.tasktracker.enums.Priority;
import com.example.tasktracker.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskUpdateResponse {
    private long id;
    private String title;
    private String description;
    private Priority priority;

    private Status status;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
}
