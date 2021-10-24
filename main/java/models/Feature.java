package models;

import Enums.FeatureImpact;
import Enums.TaskStatus;
import Enums.TaskType;

import java.util.*;

public class Feature extends Task {

    public static final Set<TaskStatus> SUPPORTED_STATUS_FOR_FEATURE = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.TESTING, TaskStatus.DEPLOYED))
    );

    private String featureSummary;
    private FeatureImpact impact;

    public Feature(
            String title, User creator, User assignee, Date dueDate,
            Sprint sprint, String featureSummary, FeatureImpact impact
    ) {
        super(title, creator, assignee, TaskType.FEATURE, dueDate, sprint);
        this.featureSummary = featureSummary;
        this.impact = impact;
    }

    public String getFeatureSummary() {
        return featureSummary;
    }

    public void setFeatureSummary(String featureSummary) {
        this.featureSummary = featureSummary;
    }

    public FeatureImpact getImpact() {
        return impact;
    }

    public void setImpact(FeatureImpact impact) {
        this.impact = impact;
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS_FOR_FEATURE;
    }
}
