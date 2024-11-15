package todoapp;

import todoapp.entity.Task;
import todoapp.enums.TaskTags;
import todoapp.service.TaskManagerImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

public class TodoApp {
    public static void main(String[] args) {
        TaskManagerImpl taskManagerImpl = new TaskManagerImpl();

        taskManagerImpl.addTask("Finish work", LocalDate.now().plusDays(2),
                new HashSet<>(List.of(TaskTags.WORK)), null);

        taskManagerImpl.addTask("Buy groceries", LocalDate.now().plusDays(1),
                new HashSet<>(List.of(TaskTags.PERSONAL)), null);

        System.out.println("All tasks:");
        List<Task> taskList =  taskManagerImpl.listTasks(true, true, null);
        taskList.forEach(System.out::println);

        taskManagerImpl.completeTask(1);

        System.out.println("Printing task List");
        System.out.println(taskManagerImpl.listTasks(true, true, null));

        taskManagerImpl.addTask("Order Food", LocalDate.now().plusDays(1),
                new HashSet<>(List.of(TaskTags.PERSONAL)), null);

        // changes the taskDeadline from 7th sept to 8th sept
        taskManagerImpl.modifyTask(2, "Buy groceries", LocalDate.now().plusDays(2),
                new HashSet<>(List.of(TaskTags.PERSONAL)), null);


        taskManagerImpl.addTask("Order Furniture", LocalDate.now().plusDays(1),
                new HashSet<>(List.of(TaskTags.PERSONAL)), LocalDateTime.now().plusDays(3));

        System.out.println("Printing task List second time");
        System.out.println(taskManagerImpl.listTasks(true, true, null));


        System.out.println("Activity log:");
        System.out.println(taskManagerImpl.getActivityLog(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1)));

        System.out.println("Statistics:");
        System.out.println(taskManagerImpl.getStatistics(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1)));


        // Printing the task list for past time interval
        // this should give empty activity log and statistics
        System.out.println("Activity log Past Time:");
        System.out.println(taskManagerImpl.getActivityLog(LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(1)));

        System.out.println("Statistics for Past Time:");
        System.out.println(taskManagerImpl.getStatistics(LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(1)));


        // Printing the task list for future time interval
        // this should give empty activity log and statistics
        System.out.println("Activity log Future Time:");
        System.out.println(taskManagerImpl.getActivityLog(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(10)));

        System.out.println("Statistics for Future Time:");
        System.out.println(taskManagerImpl.getStatistics(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(10)));

    }
}
