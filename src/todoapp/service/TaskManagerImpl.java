package todoapp.service;

import todoapp.entity.ActivityLog;
import todoapp.entity.Task;
import todoapp.enums.ActivityType;
import todoapp.enums.StatsType;
import todoapp.enums.TaskTags;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskManagerImpl implements TaskManager {
    private final Map<Integer, Task> tasks;
    private final List<ActivityLog> activityLog;
    private int taskIdCounter;

    private static final Logger logger = Logger.getLogger(TaskManagerImpl.class.getName());

    public TaskManagerImpl() {
        tasks = new HashMap<>();
        activityLog = new ArrayList<>();
        taskIdCounter = 1;
    }

    /*
        This method adds a task to the tasks map
        Logs the activity
    */
    public void addTask(String name, LocalDate deadline, Set<TaskTags> tags, LocalDateTime futureDate) {
        Task task = new Task(taskIdCounter++, name, deadline, tags, futureDate);
        tasks.put(task.getTaskId(), task);
        logActivity(ActivityType.ADDED, task);
        logger.log(Level.INFO, "Task added: {0}", task.getTaskId());
    }

    /*
        This method returns the task for the given taskId
    */
    public Task getTask(int taskId) {
        return tasks.get(taskId);
    }

    /*
        This method modifies the task for the given taskId
        Logs the activity
    */
    public void modifyTask(int taskId, String name, LocalDate deadline, Set<TaskTags> tags, LocalDateTime futureDate) {
        Task task = tasks.get(taskId);
        if (task != null) {
            tasks.put(taskId, new Task(taskId, name, deadline, tags, futureDate));
            logActivity(ActivityType.MODIFIED, task);
        } else {
            System.out.println("Task not found for taskId: " + taskId);
            throw new IllegalArgumentException("Task not found");
        }
    }

    /*
        This method removes the task for the given taskId
        Logs the activity
     */
    public void removeTask(int taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            logActivity(ActivityType.REMOVED, task);
        } else {
            logger.log(Level.INFO, "Task Not Found: {0}", taskId);
            throw new IllegalArgumentException("Task not found");
        }
    }

    /*
        This method marks the task as completed for the given taskId
        Removes the task from the tasks map
        Logs the activity
    */
    public void completeTask(int taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.markCompleted();
            tasks.remove(taskId);
            logActivity(ActivityType.COMPLETED, task);
            logger.log(Level.INFO, "Task completed: {0}", task.getTaskId());
        } else {
            logger.log(Level.INFO, "Task Not Found: {0}", taskId);
            throw new IllegalArgumentException("Task not found");
        }
    }


    /*
        This method returns the list of tasks based on the input parameters
        Iterates over the tasks and filters the tasks based on the input parameters
        If includeFutureTasks is false, skips the tasks with future date
        If filterTags is not null, skips the tasks which do not contain all the filter tags
        If sortByDeadline is true, sorts the tasks by deadline
     */
    public List<Task> listTasks(boolean includeFutureTasks, boolean sortByDeadline, Set<TaskTags> filterTags) {
        List<Task> filteredTasks = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (Task task : tasks.values()) {
            // if includeFutureTasks is false, skip tasks with future date
            // else include tasks with future date only if the future date is before now
            if (!includeFutureTasks && task.getFutureDate() != null && task.getFutureDate().isAfter(now)) {
                continue;
            }

            // if filterTags is not null and task does not contain all filter tags, skip the task
            if (filterTags != null && !task.getTags().containsAll(filterTags)) {
                continue;
            }
            filteredTasks.add(task);
        }

        // sort tasks by deadline if sortByDeadline is true
        if (sortByDeadline) {
            filteredTasks.sort(Comparator.comparing(Task::getDeadline));
        }

        return filteredTasks;
    }


    /*
        This method returns the statistics for the given time interval.
        Iterates over the activity log for fetching the added and completed task in the given interval
        Iterates over the tasks for fetching the spilled over tasks
     */
    public Map<StatsType, Integer> getStatistics(LocalDateTime from, LocalDateTime to) {
        Map<StatsType, Integer> statistics = new HashMap<>();
        statistics.put(StatsType.TASKS_ADDED, 0);
        statistics.put(StatsType.TASKS_COMPLETED, 0);
        statistics.put(StatsType.TASK_SPILLED_OVER, 0);

        for (ActivityLog activity : activityLog) {
            LocalDateTime timestamp = activity.getLocalDateTime();
            if (timestamp.isAfter(from) && timestamp.isBefore(to)) {
                if (ActivityType.ADDED.equals(activity.getActivityType())) {
                    statistics.put(StatsType.TASKS_ADDED, statistics.get(StatsType.TASKS_ADDED) + 1);
                } else if (ActivityType.COMPLETED.equals(activity.getActivityType())) {
                    statistics.put(StatsType.TASKS_COMPLETED, statistics.get(StatsType.TASKS_COMPLETED) + 1);
                }
            }
        }

        for (Task task : tasks.values()) {
            // if task deadline is before current date, increment spilled over tasks
            if (task.getDeadline() != null && task.getDeadline().isBefore(LocalDate.now())) {
                statistics.put(StatsType.TASK_SPILLED_OVER, statistics.get(StatsType.TASK_SPILLED_OVER) + 1);
            }
        }
        return statistics;
    }

    /*
        This method returns the activity log for the given time interval
        Iterates over the activity log and filters the logs based on the input time interval
     */
    public List<String> getActivityLog(LocalDateTime from, LocalDateTime to) {
        List<String> filteredLog = new ArrayList<>();
        for (ActivityLog activitylog : activityLog) {
            LocalDateTime timestamp = activitylog.getLocalDateTime();
            if (timestamp.isAfter(from) && timestamp.isBefore(to)) {
                filteredLog.add(activitylog.toString());
            }
        }
        return filteredLog;
    }

    private void logActivity(ActivityType activity, Task task) {
        activityLog.add(new ActivityLog(LocalDateTime.now(), activity, task));
    }
}

