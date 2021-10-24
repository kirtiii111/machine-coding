package Dao;

import models.*;

import java.util.*;

public class Dao {
    List<Task> taskList;
    List<Sprint> sprints;
    List<User> users;
    List<Subtask> subtasks;
    Map<String, Set<Task>> sprintIdToTaskMap;
    Map<String, Set<Task>> userIdToTaskMap;

    public Dao() {
        this.taskList = new ArrayList<>();
        this.sprints = new ArrayList<>();
        this.users = new ArrayList<>();
        this.subtasks = new ArrayList<>();
        this.sprintIdToTaskMap = new HashMap<>();
        this.userIdToTaskMap = new HashMap<>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public Map<String, Set<Task>> getSprintIdToTaskMap() {
        return sprintIdToTaskMap;
    }

    public Map<String, Set<Task>> getUserIdToTaskMap() {
        return userIdToTaskMap;
    }

    public void addTask(Task task){
        this.taskList.add(task);
        if(userIdToTaskMap.get(task.getAssignee().getId()) == null){
            userIdToTaskMap.put(task.getAssignee().getId(), new HashSet<>());
        }
        userIdToTaskMap.get(task.getAssignee().getId()).add(task);

        if(task.getSprint() == null){
            return;
        }
        if(sprintIdToTaskMap.get(task.getSprint().getId()) == null){
            sprintIdToTaskMap.put(task.getSprint().getId(), new HashSet<>());
        }
        sprintIdToTaskMap.get(task.getSprint().getId()).add(task);
    }

    public void changeAssignee(Task task, User assignee){
        userIdToTaskMap.get(task.getAssignee().getId()).remove(task);

        if(userIdToTaskMap.get(assignee.getId()) == null){
            userIdToTaskMap.put(assignee.getId(), new HashSet<>());
        }
        userIdToTaskMap.get(assignee.getId()).add(task);
        task.setAssignee(assignee);
    }

    public void changeSprint(Task task, Sprint sprint){
        if(task.getSprint() != null){
            sprintIdToTaskMap.get(task.getSprint().getId()).remove(task);;
        }

        if(sprintIdToTaskMap.get(sprint.getId()) == null){
            sprintIdToTaskMap.put(sprint.getId(), new HashSet<>());
        }
        sprintIdToTaskMap.get(sprint.getId()).add(task);
        task.setSprint(sprint);
    }

    public void printAllTasks(){
        for(Task task : taskList){
            System.out.println("Task : " + task.getTitle() + " Creator : " + task.getCreator().getName() + " Assignee : " + task.getAssignee().getName());
        }
    }
}
