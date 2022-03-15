package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks/")
    public List<Task> getList() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PostMapping("/tasks/")
    public int addTask(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            taskRepository.deleteById(id);
            return new ResponseEntity("Задача " + id + " удалена!", HttpStatus.OK);
        }
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity deleteAllList(){
        ArrayList<Task> taskOptional = (ArrayList<Task>) taskRepository.findAll();
        if (taskOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else{
            taskRepository.deleteAll();
            return new ResponseEntity("Лист задач очищен!", HttpStatus.OK);
            }
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity updateTask(@PathVariable int id, Task newTask){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(!taskOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            newTask.setId(id);
            taskRepository.save(newTask);
            return new ResponseEntity("Задача " + id + " обновлена!", HttpStatus.OK);
        }
    }
}
