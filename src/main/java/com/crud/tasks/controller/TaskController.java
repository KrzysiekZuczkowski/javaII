package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/v1/tasks")
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(taskMapper.mapToTaskDtoList(tasks));
    }

    @GetMapping(value = "{taskId}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long taskId) throws TaskNotFoundException {
            return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto) {
//        Task task = taskMapper.mapToTask(taskDto);
//        service.saveTask(task);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.saveTask(task)));
    }

//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
//        Task task = taskMapper.mapToTask(taskDto);
//        Task savedTask = service.saveTask(task);
//        return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));
//    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) throws TaskNotFoundException {
        service.getTask(taskDto.getId());
        return createTask(taskDto);
    }

//    @DeleteMapping(value = "{taskId}")
//    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) throws EmptyResultDataAccessException {
//        service.deleteTask(taskId);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping(value = "{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) throws TaskNotFoundException {
        service.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}
