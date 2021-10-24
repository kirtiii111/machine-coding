package service.impl;

import Dao.Dao;
import Enums.BugSeverity;
import Enums.FeatureImpact;
import models.*;
import service.TaskService;

import java.util.Date;

public class TaskServiceImpl implements TaskService {
    private Dao dao;

    public TaskServiceImpl(Dao dao) {
        this.dao=dao;
    }

    @Override
    public Task createStory(String title, User creator, User assignee,
                            Date dueDate, Sprint sprint, String summary) {
        Story story = new Story(title, creator, assignee, sprint, dueDate, summary);
        dao.addTask(story);
        return story;
    }

    @Override
    public Task createFeature(String title, User creator, User assignee, Date dueDate,
                         Sprint sprint, String featureSummary, FeatureImpact impact) {
        Feature feature = new Feature(title, creator, assignee, sprint, dueDate, featureSummary, impact);
        dao.addTask(feature);
        return feature;
    }

    @Override
    public Task createBug(String title, User creator, User assignee, Date dueDate, Sprint sprint, BugSeverity bugSeverity) {
        Bug bug = new Bug(title, creator, assignee, sprint, dueDate, bugSeverity);
        dao.addTask(bug);
        return bug;
    }

    @Override
    public void changeAssigneeOfTask(Task task, User assignee) {
        dao.changeAssigneeOfTask(task, assignee);
    }

    @Override
    public void printTasks() {
        dao.printTasks();
    }
}
