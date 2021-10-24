package models;

import Enums.TaskStatus;
import Enums.TaskType;

import java.util.Date;

public abstract class Task extends BaseTask{
    private User reporter;
    private User assignee;
    private Sprint sprint;
    private Date dueDate;

    public Task(String title, TaskType taskType, User reporter, User assignee, Sprint sprint, Date dueDate) {
        super(title, TaskStatus.OPEN, taskType);
        this.reporter=reporter;
        this.assignee=assignee;
        this.sprint = sprint;
        this.dueDate=dueDate;
    }

    public User getReporter() {
        return reporter;
    }

    public User getAssignee() {
        return assignee;
    }

    public Sprint getSprint() {
        return sprint;
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
}
