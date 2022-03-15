package service.impl;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;
import service.Messages;
import service.TaskService;
import service.exceptions.TaskIsNotException;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final Messages messages;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, Messages messages) {
        this.taskRepository = taskRepository;
        this.messages = messages;
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);

    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskIsNotException(messages.getMessage("task.exception.taskIsNotExist")));
    }


    @Override
    public Task updateTask(Task task) {
        taskRepository.findById(task.getId()).orElseThrow(() -> new TaskIsNotException(messages.getMessage("task.exception.taskIsNotExist")));
        taskRepository.save(task);
        return null;
    }

    @Override
    public void removeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->new TaskIsNotException(messages.getMessage("task.exception.taskIsNotExist")));
        taskRepository.delete(task);
    }
}
