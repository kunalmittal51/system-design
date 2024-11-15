package todoapp.entity;

import todoapp.enums.ActivityType;

import java.time.LocalDateTime;

public class ActivityLog {
    LocalDateTime localDateTime;
    ActivityType activityType;
    Task task;

    public ActivityLog(LocalDateTime localDateTime, ActivityType activityType, Task task) {
        this.localDateTime = localDateTime;
        this.activityType = activityType;
        this.task = task;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public Task getTask() {
        return task;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setTask(Task task) {
        this.task = task;
    }


    @Override
    public String toString() {
        return "ActivityLog{" +
                "localDateTime=" + localDateTime +
                ", activityType=" + activityType +
                ", task=" + task +
                '}';
    }
}
