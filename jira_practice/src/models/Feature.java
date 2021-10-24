package models;

import Enums.FeatureImpact;
import Enums.TaskStatus;
import Enums.TaskType;

import java.util.*;

public class Feature extends Task {
    private final Set<TaskStatus> SUPPORTED_STATUS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.TESTING, TaskStatus.DEPLOYED
    )));

    private String featureSummary;
    private FeatureImpact featureImpact;

    public Feature(String title, User reporter, User assignee, Sprint sprint, Date dueDate, String featureSummary, FeatureImpact featureImpact) {
        super(title, TaskType.FEATURE, reporter, assignee, sprint, dueDate);
        this.featureSummary=featureSummary;
        this.featureImpact=featureImpact;
    }


    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS;
    }

    public String getFeatureSummary() {
        return featureSummary;
    }

    public FeatureImpact getFeatureImpact() {
        return featureImpact;
    }

    public void setFeatureSummary(String featureSummary) {
        this.featureSummary = featureSummary;
    }

    public void setFeatureImpact(FeatureImpact featureImpact) {
        this.featureImpact = featureImpact;
    }
}
