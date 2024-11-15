package todoapp.entity;

import todoapp.enums.TaskTags;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Task {
    private final int taskId;
    private final String name;
    private final LocalDate deadline;
    private final Set<TaskTags> tags;
    private boolean completed;
    private final LocalDateTime futureDate;

    public Task(int taskId, String name, LocalDate deadline, Set<TaskTags> tags, LocalDateTime futureDate) {
        this.taskId = taskId;
        this.name = name;
        this.deadline = deadline;
        this.tags = tags != null ? tags : new HashSet<>();
        this.futureDate = futureDate;
        this.completed = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Set<TaskTags> getTags() {
        return tags;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getFutureDate() {
        return futureDate;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", name='" + name + '\'' +
                ", deadline=" + deadline + ", tags=" + tags +
                ", futureDate=" + futureDate + ", completed=" + completed + '}';
    }
}
