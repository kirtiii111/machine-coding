package models;

import enums.TaskStatus;
import enums.TaskType;
import exceptions.IncompleteSubtaskException;
import utils.SubtaskUtils;

import java.util.*;

public class Story extends Task{
    private final Set<TaskStatus> SUPPORTED_STATUS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.COMPLETED
    )));

    private String summary;
    private Set<SubTask> subTasks;

    public Story(String title, User reporter, User assignee, Sprint sprint, Date dueDate, String summary) {
        super(title, TaskType.STORY, reporter, assignee, sprint, dueDate);
        this.summary = summary;
        this.subTasks = new HashSet<>();
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS;
    }

    public Set<SubTask> getSubTasks() {
        return this.subTasks;
    }

    public void setStatus(TaskStatus status) {
        try {
            if (TaskStatus.COMPLETED.equals(status)) {
                SubtaskUtils.checkIfAllSubtasksFinished(this);
            }
            setStatus(status);
        } catch (IncompleteSubtaskException e) {
            System.out.println("Can't mark story as completed as there are panding subtasks");
        }
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
