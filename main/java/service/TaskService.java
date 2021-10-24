package service;

import Enums.BugSeverity;
import Enums.FeatureImpact;
import Enums.TaskStatus;
import models.*;

import java.util.Date;

public interface TaskService {
    Task createStory(String title, User creator, User assignee,
                     Date dueDate, Sprint sprint, String summary);
    Task createBug(String title, User creator, User assignee, Date dueDate, Sprint sprint, BugSeverity severity);
    Task createFeature(String title, User creator, User assignee, Date dueDate,
                       Sprint sprint, String featureSummary, FeatureImpact impact);
    void changeAssigneeOfTask(Task task, User assignee);
    public void changeStatusOfTask(BaseTask task, TaskStatus status);
     void printTasks();
}
