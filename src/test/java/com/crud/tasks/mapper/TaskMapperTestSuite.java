package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "TaskDto test", "test content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("TaskDto test");
        assertThat(task.getContent()).isEqualTo("test content");
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "task1 test", "test content"));

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(1, taskDtos.size());
        assertThat(taskDtos).isNotNull();
        assertThat(taskDtos.get(0).getTitle()).isEqualTo("task1 test");
        assertThat(taskDtos.get(0).getContent()).isEqualTo("test content");
    }
}