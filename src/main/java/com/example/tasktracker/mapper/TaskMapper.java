package com.example.tasktracker.mapper;

import com.example.tasktracker.dto.*;
import com.example.tasktracker.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    TaskUpdateResponse toTaskUpdateResponse(Task task);
    TaskAddResponse toAddResponse(Task task);
    Task toEntity(TaskDto taskDto);
    Task toAddRequestEntity(TaskAddRequest taskAddRequest);
    List<TaskDto> toDtos(List<Task> tasks);
    List<AllTasksResponse> toAllTasksResponse(List<Task> tasks);
    GetTaskResponse toGetTaskResponse(Task task);
    List<TaskAddResponse> toAddResponses(List<Task> tasks);
    List<Task> toEntities(List<TaskDto> taskDtos);
    List<Task> toAddRequestEntities(List<TaskAddRequest> taskAddRequests);
    TaskDto toUpdatedDto(TaskDto taskDto);

}
