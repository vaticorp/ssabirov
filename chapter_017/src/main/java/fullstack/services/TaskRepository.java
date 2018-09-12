package fullstack.services;

import fullstack.models.Task;
import java.util.List;

/**
 * This class represents interface for task-operations.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 11.
 */
public interface TaskRepository {
    Task addTask(Task task);
    List<Task> getAll();
    Task updateTask(Task task);
    Task getTaskById(long id);
    void removeTask(Task task);
}
