package sprintplanner;

import sprintplanner.enums.TaskStatus;
import sprintplanner.enums.TaskType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SprintPlanner {
    private final Map<Integer, Sprint> sprints = new HashMap<>();
    private final Map<Integer, User> users = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public void createSprint(int sprintId, String name) {
        lock.lock();
        try {
            if (sprints.containsKey(sprintId)) {
                throw new IllegalArgumentException("Sprint with id " + sprintId + " already exists");
            }
            sprints.put(sprintId, new Sprint(sprintId, name));
        } finally {
            lock.unlock();
        }
    }

    public void createUser(int userId, String name) {
        lock.lock();
        try {
            if (users.containsKey(userId)) {
                throw new IllegalArgumentException("User with id " + userId + " already exists");
            }
            users.put(userId, new User(userId, name));
        } finally {
            lock.unlock();
        }
    }

    public void addTaskToSprint(int sprintId, int taskId, String taskName, TaskType taskType, int userId) {
        lock.lock();
        try {
            if (!sprints.containsKey(sprintId)) {
                throw new IllegalArgumentException("Sprint with id " + sprintId + " does not exist");
            }
            if (!users.containsKey(userId)) {
                throw new IllegalArgumentException("User with id " + userId + " does not exist");
            }
            User user = users.get(userId);
            Task task = new Task(taskId, taskName, taskType, user);
            Sprint sprint = sprints.get(sprintId);
            sprint.addTask(task);
            user.assignTask(task);
        } finally {
            lock.unlock();
        }
    }

    public void removeTaskFromSprint(int sprintId, int taskId) {
        lock.lock();
        try {
            if (!sprints.containsKey(sprintId)) {
                throw new IllegalArgumentException("Sprint with id " + sprintId + " does not exist");
            }
            Sprint sprint = sprints.get(sprintId);
            Task task = sprint.getTasks().stream()
                    .filter(t -> t.getTaskId() == taskId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " does not exist in sprint " + sprintId));
            sprint.removeTask(task);
            task.getUser().removeTask(task);
        } finally {
            lock.unlock();
        }
    }

    public void changeTaskStatus(int sprintId, int taskId, TaskStatus newStatus) {
        lock.lock();
        try {
            if (!sprints.containsKey(sprintId)) {
                throw new IllegalArgumentException("Sprint with id " + sprintId + " does not exist");
            }
            Sprint sprint = sprints.get(sprintId);
            Task task = sprint.getTasks().stream()
                    .filter(t -> t.getTaskId() == taskId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " does not exist in sprint " + sprintId));
            // Check if the user has more than 2 INPROGRESS tasks
            if (newStatus == TaskStatus.IN_PROGRESS && task.getUser().getTasks().stream()
                    .filter(t -> t.getStatus() == TaskStatus.IN_PROGRESS).count() >= 2) {
                throw new IllegalArgumentException("User " + task.getUser().getName() + " cannot have more than 2 tasks in INPROGRESS status");
            }
            task.changeStatus(newStatus);
        } finally {
            lock.unlock();
        }
    }

    public List<Task> getUserTasksInSprint(int sprintId, int userId) {
        if (!sprints.containsKey(sprintId)) {
            throw new IllegalArgumentException("Sprint with id " + sprintId + " does not exist");
        }
        if (!users.containsKey(userId)) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }
        Sprint sprint = sprints.get(sprintId);
        User user = users.get(userId);
        return sprint.getUserTasks(user);
    }

    public List<Task> getDelayedTasksInSprint(int sprintId) {
        if (!sprints.containsKey(sprintId)) {
            throw new IllegalArgumentException("Sprint with id " + sprintId + " does not exist");
        }
        Sprint sprint = sprints.get(sprintId);
        return sprint.getDelayedTasks();
    }
}

