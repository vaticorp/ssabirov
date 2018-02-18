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
        int position = 0;
        for (int index = 0; index < tasks.size(); index++) {
            position = index;
            Task currentTask = tasks.get(index);
            if (currentTask.getPriority() >= task.getPriority()) {
                break;
            }
        }
        tasks.add(position, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}