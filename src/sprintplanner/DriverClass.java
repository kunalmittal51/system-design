package sprintplanner;

import sprintplanner.enums.TaskStatus;
import sprintplanner.enums.TaskType;

public class DriverClass {
        public static void main(String[] args) {
            SprintPlanner planner = new SprintPlanner();

            // Create users
            planner.createUser(1, "Alice");
            planner.createUser(2, "Bob");

            // Create a sprint
            planner.createSprint(1, "Sprint 1");

            // Add tasks to sprint
            planner.addTaskToSprint(1, 1, "Implement login", TaskType.FEATURE, 1);
            planner.addTaskToSprint(1, 2, "Fix bug #123", TaskType.BUG, 1);
            planner.addTaskToSprint(1, 3, "Implement signup", TaskType.FEATURE, 2);

            // Change task status
            planner.changeTaskStatus(1, 1, TaskStatus.IN_PROGRESS);
            planner.changeTaskStatus(1, 2, TaskStatus.IN_PROGRESS);

            // Print tasks assigned to Alice
            System.out.println("Tasks assigned to Alice:");
            for (Task task : planner.getUserTasksInSprint(1, 1)) {
                System.out.println(task.getName() + " - " + task.getStatus());
            }

            // Print delayed tasks
            System.out.println("Delayed tasks in Sprint 1:");
            for (Task task : planner.getDelayedTasksInSprint(1)) {
                System.out.println(task.getName() + " - " + task.getStatus());
            }
        }
}
