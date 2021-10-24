package models;

import Enums.TaskStatus;
import Enums.TaskType;
import Utils.StatusUtils;
import exceptions.InvalidStatusForTaskException;

import java.util.Set;
import java.util.UUID;

public abstract class BaseTask {
    private String id;
    private String title;
    private TaskStatus status;
    private TaskType type;

    public BaseTask(String title, TaskStatus status, TaskType taskType) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.status = status;
        this.type = taskType;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        try{
            StatusUtils.validateStatus(this, status);
            this.status = status;
        } catch (InvalidStatusForTaskException e) {
            System.out.println("Invalid status : " + status.getDisplayName() + " for task of type " + getType().getDisplayName());
        }
    }

    public TaskType getType() {
        return type;
    }

    public abstract Set<TaskStatus> getSupportedStatus();
}
