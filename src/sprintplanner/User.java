package sprintplanner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class User {
    private final int userId;
    private final String name;
    private final List<Task> tasks = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void assignTask(Task task) {
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

    public List<Task> getTasks() {
        lock.lock();
        try {
            return new ArrayList<>(tasks);
        } finally {
            lock.unlock();
        }
    }
}

