package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTask(final Long taskId) throws TaskNotFoundException {
        Supplier<TaskNotFoundException> supplier =
                () -> new TaskNotFoundException("Task with given id doesn't exist");
        return repository.findById(taskId).orElseThrow(supplier);
//        return repository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }

    public Task saveTask(final Task task) {
        return repository.save(task);
    }

//    public void deleteTask(final Long taskId){
//        repository.deleteById(taskId);
//    }

    public void deleteTask(final Long taskId) throws TaskNotFoundException {
        repository.delete(getTask(taskId));
    }
}
