package ru.job4j.search;

import java.util.*;

/**
 * This is simple class for PriorityQueue.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 27.02.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        Task current = tasks.stream().filter(currentTask -> currentTask.getPriority() >= task.getPriority()).max(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getPriority() - o2.getPriority() > 0 ? 1 : -1;
            }
        }).orElseGet(()-> new Task("",0));
        tasks.add(tasks.indexOf(current) == -1 ? 0 : tasks.indexOf(current), task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}