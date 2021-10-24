package service;

import Dao.Dao;
import Enums.BugSeverity;
import Enums.FeatureImpact;
import Enums.TaskStatus;
import models.*;

import java.util.Date;

public class TaskServiceImpl implements TaskService {
    private Dao dao;

    public TaskServiceImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Task createStory(String title, User creator, User assignee, Date dueDate, Sprint sprint, String summary) {
        Story story = new Story(title, creator, assignee, dueDate, sprint, summary);
        dao.addTask(story);
        return story;
    }

    @Override
    public Task createBug(String title, User creator, User assignee, Date dueDate, Sprint sprint, BugSeverity severity) {
        Bug bug = new Bug(title, creator, assignee, dueDate, sprint, severity);
        dao.addTask(bug);
        return bug;
    }

    @Override
    public Task createFeature(String title, User creator, User assignee, Date dueDate, Sprint sprint, String featureSummary, FeatureImpact impact) {
        Feature feature = new Feature(title, creator, assignee, dueDate, sprint, featureSummary, impact);
        dao.addTask(feature);
        return feature;
    }

    @Override
    public void changeStatusOfTask(BaseTask task, TaskStatus status) {
        task.setStatus(status);
    }

    @Override
    public void changeAssigneeOfTask(Task task, User assignee) {
        dao.changeAssignee(task, assignee);
    }

    @Override
    public void printTasks() {
        dao.printAllTasks();
    }
}
