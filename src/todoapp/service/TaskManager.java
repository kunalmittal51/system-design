package todoapp.service;

import todoapp.entity.Task;
import todoapp.enums.StatsType;
import todoapp.enums.TaskTags;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskManager {
    void addTask(String name, LocalDate deadline, Set<TaskTags> tags, LocalDateTime futureDate);
    Task getTask(int taskId);
    void modifyTask(int taskId, String name, LocalDate deadline, Set<TaskTags> tags, LocalDateTime futureDate);
    void removeTask(int taskId);
    void completeTask(int taskId);
    List<Task> listTasks(boolean includeFutureTasks, boolean sortByDeadline, Set<TaskTags> filterTags);
    Map<StatsType, Integer> getStatistics(LocalDateTime from, LocalDateTime to);
    List<String> getActivityLog(LocalDateTime from, LocalDateTime to);
}
