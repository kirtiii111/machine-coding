package models;

import Enums.BugSeverity;
import Enums.TaskStatus;
import Enums.TaskType;

import java.util.*;

public class Bug extends Task{
    private final Set<TaskStatus> SUPPORTED_STATUS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.FIXED
    )));

    private BugSeverity bugSeverity;

    public Bug(String title, User reporter, User assignee, Sprint sprint, Date dueDate, BugSeverity bugSeverity) {
        super(title, TaskType.BUG, reporter, assignee, sprint, dueDate);
        this.bugSeverity=bugSeverity;
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS;
    }

    public BugSeverity getBugSeverity() {
        return bugSeverity;
    }

    public void setBugSeverity(BugSeverity bugSeverity) {
        this.bugSeverity = bugSeverity;
    }
}
