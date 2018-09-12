package fullstack.services;

import fullstack.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service-class for Task.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 13.
 */
@Service
@Transactional
public class TaskService implements TaskRepository {

    @Autowired
    private TaskCrud taskCrud;

    @Override
    public Task addTask(Task task) {
        return taskCrud.save(task);
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        this.taskCrud.findAll().forEach(s -> list.add(s));
        return list;
    }

    @Override
    public Task updateTask(Task task) {
        return taskCrud.save(task);
    }

    @Override
    public Task getTaskById(long id) {
        return taskCrud.findById(id).get();
    }

    @Override
    public void removeTask(Task task) {
        taskCrud.delete(task);
    }
}
