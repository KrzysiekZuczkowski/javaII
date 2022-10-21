package com.crud.tasks.domain;

import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void taskRepositorySaveTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "name", "dscription");

        //When
        Task savedTask = taskRepository.save(taskMapper.mapToTask(taskDto));

        //Then
        Long id = savedTask.getId();
        System.out.println("Task Id " + id);
        Optional<Task> readTask = taskRepository.findById(id);
        assertTrue(readTask.isPresent());

        //CleanUp
        taskRepository.deleteById(id);
    }
}
