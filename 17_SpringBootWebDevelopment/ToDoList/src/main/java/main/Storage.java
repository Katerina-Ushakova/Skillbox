package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<Integer,Task>();

    public static List<Task> getAllTasks() {
        ArrayList<Task> tasksList = new ArrayList<Task>();
        tasksList.addAll(tasks.values());
        return tasksList;
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId) {
        if(tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static void deleteTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.remove(taskId);
        }
    }

    public static void deleteAllTasks() {
        tasks.clear();
    }

    public static void updateTask(int taskId, Task newTask) {
        tasks.replace(taskId,newTask);
    }
}
