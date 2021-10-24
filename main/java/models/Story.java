package models;

import Enums.TaskStatus;
import Enums.TaskType;
import Utils.SubtaskUtils;
import exceptions.IncompleteSubtaskException;

import java.util.*;

public class Story extends Task {

    public static final Set<TaskStatus> SUPPORTED_STATUS_FOR_STORY = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.COMPLETED))
    );

    private String summary;
    private Set<Subtask> subtasks;

    public Story(
            String title, User creator, User assignee,
            Date dueDate, Sprint sprint, String summary
    ) {
        super(title, creator, assignee, TaskType.STORY, dueDate, sprint);
        this.summary = summary;
        subtasks = new HashSet<>();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS_FOR_STORY;
    }

    @Override
    public void setStatus(TaskStatus status) {
        try{
            if(TaskStatus.COMPLETED.equals(status)){
                SubtaskUtils.checkIfAllSubTasksFinished(this);
            }
            super.setStatus(status);
        } catch (IncompleteSubtaskException e) {
            System.out.println("Can't mark story as completed as there are panding subtasks");
        }
    }
}
