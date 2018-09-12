package fullstack.services;

import fullstack.models.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * This class represents crud for task.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 10.
 */
public interface TaskCrud extends CrudRepository<Task, Long> {
}
