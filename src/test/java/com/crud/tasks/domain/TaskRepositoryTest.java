package com.crud.tasks.domain;

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

    @Test
    void taskRepositorySaveTest() {
        //Given
        Task task = new Task("name", "dscription");

        //When
        taskRepository.save(task);

        //Then
        Long id = task.getId();
        Optional<Task> readTask = taskRepository.findById(id);
        assertTrue(readTask.isPresent());
    }
}
