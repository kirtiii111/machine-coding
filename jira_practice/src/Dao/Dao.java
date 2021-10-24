package Dao;

import models.Sprint;
import models.Task;
import models.User;

import java.util.*;

public class Dao {
    List<Task> taskList;
    List<Sprint> sprints;

    Map<String, Set<Task>> userIdToTask;
    Map<String, Set<Task>> sprintIdToTask;

    public Dao() {
        this.taskList=new ArrayList<>();
        this.userIdToTask=new HashMap<>();
        this.sprints = new ArrayList<>();
        this.sprintIdToTask = new HashMap<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
        userIdToTask.putIfAbsent(task.getAssignee().getId(), new HashSet<>());
        userIdToTask.get(task.getAssignee().getId()).add(task);

        if (task.getSprint() == null ) {
            return;
        }
        if (sprintIdToTask.get(task.getSprint().getId()) == null) {
            sprintIdToTask.put(task.getSprint().getId(), new HashSet<>());
        }
        sprintIdToTask.get(task.getSprint().getId()).add(task);
    }


    public void changeAssigneeOfTask(Task task, User assignee) {
        userIdToTask.get(task.getAssignee().getId()).remove(task);

        if (userIdToTask.get(assignee.getId()) == null) {
            userIdToTask.put(assignee.getId(), new HashSet<>());
        }
        userIdToTask.get(assignee.getId()).add(task);
        task.setAssignee(assignee);
    }

    public void printTasks() {
        for (Task task: taskList) {
            System.out.println("Task " + task.getTitle() + " Creator " + task.getReporter().getName() + " Assignee " + task.getAssignee().getName());
        }
    }
}
