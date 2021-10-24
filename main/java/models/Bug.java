package models;

import Enums.BugSeverity;
import Enums.TaskStatus;
import Enums.TaskType;

import java.util.*;

public class Bug extends Task {

    public static final Set<TaskStatus> SUPPORTED_STATUS_FOR_BUG = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.FIXED))
    );

    private BugSeverity severity;

    public Bug(String title, User creator, User assignee, Date dueDate, Sprint sprint, BugSeverity severity) {
        super(title, creator, assignee, TaskType.BUG, dueDate, sprint);
        this.severity = severity;
    }

    public BugSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(BugSeverity severity) {
        this.severity = severity;
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS_FOR_BUG;
    }
}
