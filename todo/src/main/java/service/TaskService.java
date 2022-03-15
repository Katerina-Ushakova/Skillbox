package service;

import model.Task;

import java.util.List;
import java.util.Map;

public interface TaskService {

    void addTask(Task task);

    List<Task> getTasks();

    Task getTask(Long id);


    Task updateTask(Task task);

    void removeTask(Long id);

}
