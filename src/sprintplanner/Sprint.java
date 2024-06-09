package sprintplanner;

import sprintplanner.enums.TaskStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sprint {
    private final int sprintId;
    private final String name;

    public List<Task> getTasks() {
        return tasks;
    }

    private final List<Task> tasks = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public Sprint(int sprintId, String name) {
        this.sprintId = sprintId;
        this.name = name;
    }

    public int getSprintId() {
        return sprintId;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        lock.lock();
        try {
            tasks.add(task);
        } finally {
            lock.unlock();
        }
    }

    public void removeTask(Task task) {
        lock.lock();
        try {
            tasks.remove(task);
        } finally {
            lock.unlock();
        }
    }

    public List<Task> getUserTasks(User user) {
        lock.lock();
        try {
            List<Task> userTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.getUser().equals(user)) {
                    userTasks.add(task);
                }
            }
            return userTasks;
        } finally {
            lock.unlock();
        }
    }

    public List<Task> getDelayedTasks() {
        lock.lock();
        try {
            List<Task> delayedTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.getStatus() != TaskStatus.DONE) {
                    delayedTasks.add(task);
                }
            }
            return delayedTasks;
        } finally {
            lock.unlock();
        }
    }
}

