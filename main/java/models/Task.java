package models;

import Enums.TaskStatus;
import Enums.TaskType;

import java.util.Date;
import java.util.UUID;

public abstract class Task extends BaseTask{
    private User creator;
    private User assignee;
    private Date dueDate;
    private Sprint sprint;

    public Task(String title, User creator, User assignee, TaskType type, Date dueDate, Sprint sprint) {
        super(title, TaskStatus.OPEN, type);
        this.creator = creator;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.sprint = sprint;
    }

    public User getCreator() {
        return creator;
    }

    public User getAssignee() {
        return assignee;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
