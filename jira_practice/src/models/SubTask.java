package models;

import enums.TaskStatus;
import enums.TaskType;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubTask extends BaseTask{
    private final Set<TaskStatus> SUPPORTED_STATUS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TaskStatus.OPEN, TaskStatus.IN_PROGRESS, TaskStatus.COMPLETED
    )));

    private Story linkedStory;

    public SubTask(String title) {
        super(title, TaskStatus.OPEN, TaskType.SUBTASK);
        this.linkedStory=null;
    }

    @Override
    public Set<TaskStatus> getSupportedStatus() {
        return SUPPORTED_STATUS;
    }

    public Story getLinkedStory() {
        return linkedStory;
    }

    public void setLinkedStory(Story linkedStory) {
        this.linkedStory = linkedStory;
    }
}
