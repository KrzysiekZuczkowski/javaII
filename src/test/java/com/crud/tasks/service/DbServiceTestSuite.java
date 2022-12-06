package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTestSuite {

    @Autowired
    private DbService dbService;

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void getAllTasks() {
        //Given
        TaskDto taskDto1 = new TaskDto(1L, "task1 test", "test content");
        TaskDto taskDto2 = new TaskDto(2L, "task2 test", "test content");
        dbService.saveTask(taskMapper.mapToTask(taskDto1));
        dbService.saveTask(taskMapper.mapToTask(taskDto2));
        //When
        List<Task> tasks = dbService.getAllTasks();
        //Then
        assertEquals(2, tasks.size());
        assertEquals("test content", tasks.get(0).getContent());

        //CleanUp
        try {
            dbService.deleteTask(tasks.get(0).getId());
            dbService.deleteTask(tasks.get(1).getId());
            dbService.deleteTask(1l);
        }catch (TaskNotFoundException e) {
            assertEquals("Task with given id doesn't exist", e.getMessage());
        }
    }

    @Test
    void getTask() {
        //Given
        TaskDto taskDto1 = new TaskDto(1L, "task1 test", "test content");
        Task savedTask = dbService.saveTask(taskMapper.mapToTask(taskDto1));

        //When
        Task task = null;
        try {
            task = dbService.getTask(savedTask.getId());
        } catch (TaskNotFoundException e) {
            assertEquals("Task with given id doesn't exist", e.getMessage());
        }

        //Then
        assertEquals("task1 test", task.getTitle());

        //CleanUp
        try {
            dbService.deleteTask(savedTask.getId());
        }catch (TaskNotFoundException e) {
            assertEquals("Task with given id doesn't exist", e.getMessage());
        }
    }

    @Test
    void deleteTask() throws TaskNotFoundException {
        //Given
        TaskDto taskDto1 = new TaskDto(1L, "task1 test", "test content");
        Task savedTask = dbService.saveTask(taskMapper.mapToTask(taskDto1));

        //When
        dbService.deleteTask(savedTask.getId());

        //Then
        assertTrue(dbService.getAllTasks().size() < 1);
    }
}