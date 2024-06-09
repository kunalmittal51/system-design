package sprintplanner;

import sprintplanner.enums.TaskStatus;
import sprintplanner.enums.TaskType;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
    private final int taskId;
    private final String name;
    private final TaskType taskType;
    private TaskStatus status;
    private final User user;
    private final Lock lock = new ReentrantLock();

    public Task(int taskId, String name, TaskType taskType, User user) {
        this.taskId = taskId;
        this.name = name;
        this.taskType = taskType;
        this.status = TaskStatus.TODO;
        this.user = user;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public void changeStatus(TaskStatus newStatus) throws IllegalArgumentException {
        lock.lock();
        try {
            if (status == TaskStatus.TODO && newStatus == TaskStatus.IN_PROGRESS) {
                status = newStatus;
            } else if (status == TaskStatus.IN_PROGRESS && (newStatus == TaskStatus.TODO || newStatus == TaskStatus.DONE)) {
                status = newStatus;
            } else {
                throw new IllegalArgumentException("Invalid status transition from " + status + " to " + newStatus);
            }
        } finally {
            lock.unlock();
        }
    }
}
