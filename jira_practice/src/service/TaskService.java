package service;

import Enums.BugSeverity;
import Enums.FeatureImpact;
import models.Feature;
import models.Sprint;
import models.Task;
import models.User;

import java.util.Date;

public interface TaskService {
    Task createStory(String title, User creator, User assignee,
                     Date dueDate, Sprint sprint, String summary);

    Task createFeature(String title, User creator, User assignee, Date dueDate,
                       Sprint sprint, String featureSummary, FeatureImpact impact);

    Task createBug(String title, User creator, User assignee, Date dueDate, Sprint sprint, BugSeverity bugSeverity);

    void changeAssigneeOfTask(Task task, User assignee);

    void printTasks();
}
